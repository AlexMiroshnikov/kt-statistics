package me.ilex.statistics.tools

import me.ilex.statistics.exceptions.InvalidArgumentException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class PearsonCorrelationTest {

    @Test
    fun `it calculates Pearson correlation coefficient correctly`() {
        val p =
            PearsonCorrelation(
                arrayOf(10, 9.8, 8, 7.8, 7.7, 7, 6, 5, 4, 2).map { it.toDouble() }.toDoubleArray(),
                intArrayOf(200, 44, 32, 24, 22, 17, 15, 12, 8, 4)
            )
        assertEquals("0.612", "%.3f".format(p.correlationCoef()))
    }

    @Test
    fun `constructor throws an exception - when x and y of different sizes are given`() {
        assertThrows<InvalidArgumentException> { PearsonCorrelation(intArrayOf(1), intArrayOf()) }
        assertThrows<InvalidArgumentException> { PearsonCorrelation(intArrayOf(), intArrayOf(1)) }
    }

    @Test
    fun `its possible to construct by Int and Int arrays`() {
        val p = PearsonCorrelation(intArrayOf(1), intArrayOf(1))
        assertEquals(1.0, p.correlationCoef())
    }

    @Test
    fun `its possible to construct by Int and Double arrays`() {
        val p = PearsonCorrelation(intArrayOf(1), doubleArrayOf(1.0))
        assertEquals(1.0, p.correlationCoef())
    }

    @Test
    fun `covariance is 0 - when x is empty`() {
        val p = PearsonCorrelation(intArrayOf(), intArrayOf())
        assertEquals(0.0, p.covariance())
    }
}
