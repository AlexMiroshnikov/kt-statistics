package me.ilex.statistics.util

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ErfTest {

    @Test
    fun `it calculates expected values`() {
        listOf(Pair(0.0, 0.000000), Pair(1.0, 0.842701), Pair(2.0, 0.995322))
            .forEach { assertEquals("%.6f".format(it.second), "%.6f".format(Erf.calc(it.first))) }
    }
}
