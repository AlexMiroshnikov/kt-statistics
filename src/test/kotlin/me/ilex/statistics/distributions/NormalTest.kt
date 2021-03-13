package me.ilex.statistics.distributions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class NormalTest {
    @Test
    fun `results of makeThroughDeviation and makeThroughVariance are identical - when same base arguments are passed`() {
        val expectation = 0.0
        val stdDeviation = 1.0
        val variance = stdDeviation * stdDeviation

        val n1 = Normal.makeThroughDeviation(expectation, stdDeviation)
        val n2 = Normal.makeThroughVariance(expectation, variance)

        val x = 0.5

        assertEquals(n1.probabilityDensity(x), n2.probabilityDensity(x))
    }

    @Test
    fun `cumulative probability is calculated properly`() {
        val d = Normal(20.0, 2.0)
        assertEquals("0.401", "%.3f".format(d.cumulativeProbability(19.5)))
        assertEquals(
            "0.341",
            "%.3f".format(d.cumulativeProbability(22.0) - d.cumulativeProbability(20.0))
        )
    }
}
