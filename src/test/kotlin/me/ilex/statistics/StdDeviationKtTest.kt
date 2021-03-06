package me.ilex.statistics

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class StdDeviationKtTest {

    @Test
    fun `it returns std deviation - if array of int of length gt 1 is given`() {
        assertEquals(14.142135623730951, stdDeviation(arrayOf(10, 40, 30, 50, 20)))
    }
}
