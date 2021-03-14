package me.ilex.statistics.tools

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SpearmanTest {

    @Test
    fun `it calculates Spearmans rank correlation coefficient correctly`() {
        val x = doubleArrayOf(0.2, 1.3, 0.2, 1.1, 1.4, 1.5)
        val y = doubleArrayOf(1.9, 2.2, 3.1, 1.2, 2.2, 2.2)
        assertEquals("0.158114", "%.6f".format(Spearman.rankCorrelationCoef(x, y)))
    }
}
