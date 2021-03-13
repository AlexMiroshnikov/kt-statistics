package me.ilex.statistics.distributions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class NegativeBinomialTest {

    @Test
    fun `exact probability is calculated correctly`() {
        val d = NegativeBinomial(10, 0.5)
        assertEquals(0.12304688.toString(), "%.8f".format(d.probabilityExact(5)))
    }
}
