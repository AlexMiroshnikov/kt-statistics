package me.ilex.statistics

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class InterquartileRangeKtTest {

    @Test
    fun `it returns 0 - if empty array of int is given`() {
        assertEquals(0.0, interquartileRange(intArrayOf()))
    }

    @Test
    fun `it returns 0 - if empty array of double is given`() {
        assertEquals(0.0, interquartileRange(doubleArrayOf()))
    }

    @Test
    fun `it returns interquartile range - if array of int of length gt 1 is given`() {
        assertEquals(
            9.0,
            interquartileRange(
                intArrayOf().plus(IntArray(5) { 6 })
                    .plus(IntArray(4) { 12 })
                    .plus(IntArray(3) { 8 })
                    .plus(IntArray(2) { 10 })
                    .plus(IntArray(1) { 20 })
                    .plus(IntArray(5) { 16 })
            )
        )
    }

    @Test
    fun `it returns interquartile range - if array of double of length gt 1 is given`() {
        assertEquals(
            9.0,
            interquartileRange(
                doubleArrayOf().plus(DoubleArray(5) { 6.0 })
                    .plus(DoubleArray(4) { 12.0 })
                    .plus(DoubleArray(3) { 8.0 })
                    .plus(DoubleArray(2) { 10.0 })
                    .plus(DoubleArray(1) { 20.0 })
                    .plus(DoubleArray(5) { 16.0 })
            )
        )
    }
}
