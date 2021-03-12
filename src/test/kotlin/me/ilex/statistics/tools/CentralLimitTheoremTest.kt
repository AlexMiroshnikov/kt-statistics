package me.ilex.statistics.tools

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CentralLimitTheoremTest {

    @Test
    fun `probability is calculated properly`() {
        val t = CentralLimitTheorem(205.0, 15.0)
        assertEquals("0.0098", "%.4f".format(t.probability(49.0, 9800.0)))
    }
}
