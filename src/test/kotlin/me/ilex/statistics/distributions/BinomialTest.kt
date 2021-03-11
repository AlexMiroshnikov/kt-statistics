package me.ilex.statistics.distributions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class BinomialTest {
    @Test
    fun `when fair coin is tossed N times - probability of getting S heads is correct`() {
        val d = Binomial(10, 0.5)
        assertEquals(0.24609375.toString(), "%.8f".format(d.probabilityExact(5)))
    }

    @Test
    fun `when fair coin is tossed N times - probability of getting at least S heads is correct`() {
        val d = Binomial(10, 0.5)
        assertEquals(0.623046875.toString(), "%.9f".format(d.probabilityAtLeast(5)))
    }

    @Test
    fun `when fair coin is tossed N times - probability of getting at most S heads is correct`() {
        val d = Binomial(10, 0.5)
        assertEquals(0.623046875.toString(), "%.9f".format(d.probabilityAtMost(5)))
    }
}
