package me.ilex.statistics.tools

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CentralLimitTheoremTest {

    @Test
    fun `probability is calculated properly`() {
        val t = CentralLimitTheorem(205.0, 15.0)
        assertEquals("0.0098", "%.4f".format(t.probability(49.0, 9800.0)))
    }

    @Test
    fun `prediction interval is calculated properly`() {
        val t = CentralLimitTheorem(500.0, 8.0)
        val (A, B) = t.predictionInterval(1.96)
        assertEquals(484.32, A)
        assertEquals(515.68, B)
    }
}
