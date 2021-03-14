package me.ilex.statistics.regressions

import me.ilex.statistics.exceptions.InvalidArgumentException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class MultipleLinearTest {

    companion object {
        private const val EXPECTED_COEFS =
            "51.953488372093005 6.651162790697665 -11.162790697674431"
    }

    @Test
    fun `it calculates coefs properly - when constructed through vararg`() {
        val ml =
            MultipleLinear(
                intArrayOf(5, 6, 7, 8, 9).map { it.toDouble() }.toDoubleArray(),
                intArrayOf(7, 6, 4, 5, 6).map { it.toDouble() }.toDoubleArray(),
                intArrayOf(10, 20, 60, 40, 50).map { it.toDouble() }.toDoubleArray()
            )
        assertEquals(EXPECTED_COEFS, ml.coefs().toSingleLine())
    }

    @Test
    fun `it calculates coefs properly - when constructed through explicit X and Y args`() {
        val ml =
            MultipleLinear(
                listOf(
                    doubleArrayOf(5.0, 6.0, 7.0, 8.0, 9.0),
                    doubleArrayOf(7.0, 6.0, 4.0, 5.0, 6.0)
                ),
                doubleArrayOf(10.0, 20.0, 60.0, 40.0, 50.0)
            )
        assertEquals(EXPECTED_COEFS, ml.coefs().toSingleLine())
    }

    @Test
    fun `it throws an exception - when being constructed with less than 2 args`() {
        assertThrows<InvalidArgumentException> { MultipleLinear(doubleArrayOf(1.0)) }
    }
}
