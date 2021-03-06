package me.ilex.statistics

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class InterquartileRangeKtTest {

    @Test
    fun `it returns 0 - if empty array of int is given`() {
        assertEquals(0.0, interquartileRange(emptyArray<Int>()))
    }

    @Test
    fun `it returns 0 - if empty array of double is given`() {
        assertEquals(0.0, interquartileRange(emptyArray<Double>()))
    }

    @Test
    fun `it returns interquartile range - if array of int of length gt 1 is given`() {
        assertEquals(
            9.0,
            interquartileRange(
                emptyArray<Int>().plus(Array(5) { 6 })
                    .plus(Array(4) { 12 })
                    .plus(Array(3) { 8 })
                    .plus(Array(2) { 10 })
                    .plus(Array(1) { 20 })
                    .plus(Array(5) { 16 })
            )
        )
    }

    @Test
    fun `it returns interquartile range - if array of double of length gt 1 is given`() {
        assertEquals(
            9.0,
            interquartileRange(
                emptyArray<Double>().plus(Array(5) { 6.0 })
                    .plus(Array(4) { 12.0 })
                    .plus(Array(3) { 8.0 })
                    .plus(Array(2) { 10.0 })
                    .plus(Array(1) { 20.0 })
                    .plus(Array(5) { 16.0 })
            )
        )
    }
}
