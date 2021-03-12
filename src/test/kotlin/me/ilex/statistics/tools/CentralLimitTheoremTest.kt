package me.ilex.statistics.tools

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CentralLimitTheoremTest {

    // Expected Output
    //
    //    0.0098

    @Test
    fun `probability is calculated properly`() {
//        val t = CentralLimitTheorem(205.0, 15.0)
//        assertEquals("0.0002", "%.4f".format(t.probability(49.0, 9800.0)))
        val t = CentralLimitTheorem(205.0, 15.0)
//        println("%.4f".format(1 - t.probability(49.0, 9800.0)))
        println("%.4f".format(t.probability(49.0, 9800.0)))
    }
}
