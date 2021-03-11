package me.ilex.statistics.distributions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GeometricTest {
    @Test
    fun `when success probability and amount of trials is given - probability of Nth trial being successful is correct`() {
        val d = Geometric(5, 0.7)
        assertEquals(0.00567.toString(), "%.5f".format(d.probabilityExact(1)))
    }
}
