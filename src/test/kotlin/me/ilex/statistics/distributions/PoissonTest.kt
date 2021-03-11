package me.ilex.statistics.distributions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class PoissonTest {

    @Test
    fun `it calculates probability of exact amount correct`() {
        val d = Poisson(2)
        assertEquals("0.180", "%.3f".format(d.probabilityExact(3)))
    }

    @Test
    fun `it calculates probability of at most amount correct`() {
        val d = Poisson(5)
        assertEquals("0.2650", "%.4f".format(d.probabilityAtMost(3)))
    }
}
