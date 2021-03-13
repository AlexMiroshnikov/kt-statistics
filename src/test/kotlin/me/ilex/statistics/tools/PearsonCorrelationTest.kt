package me.ilex.statistics.tools

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class PearsonCorrelationTest {

    @Test
    fun `it calculates Pearson correlation coefficient correctly`() {
        val p =
            PearsonCorrelation(
                arrayOf(10, 9.8, 8, 7.8, 7.7, 7, 6, 5, 4, 2).map { it.toDouble() }.toTypedArray(),
                arrayOf(200, 44, 32, 24, 22, 17, 15, 12, 8, 4)
            )
        assertEquals("0.612", "%.3f".format(p.correlationCoef()))
    }
}
