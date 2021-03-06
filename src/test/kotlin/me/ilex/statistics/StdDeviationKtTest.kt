package me.ilex.statistics

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class StdDeviationKtTest {

    @Test
    fun `it returns 9 - if empty array of int is given`() {
        assertEquals(0.0, stdDeviation(emptyArray<Int>()))
    }
    @Test
    fun `it returns 9 - if empty array of double is given`() {
        assertEquals(0.0, stdDeviation(emptyArray<Double>()))
    }

    @Test
    fun `it returns std deviation - if array of int of length gt 1 is given`() {
        assertEquals(14.142135623730951, stdDeviation(arrayOf(10, 40, 30, 50, 20)))
    }

    @Test
    fun `it returns std deviation - if array of double of length gt 1 is given`() {
        assertEquals(14.142135623730951, stdDeviation(arrayOf(10.0, 40.0, 30.0, 50.0, 20.0)))
    }
}
