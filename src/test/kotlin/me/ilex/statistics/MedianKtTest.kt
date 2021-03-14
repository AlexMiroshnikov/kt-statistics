package me.ilex.statistics

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MedianKtTest {

    @Test
    fun `it returns 0 - if empty array of int is passed`() {
        assertEquals(0.0, median(emptyArray<Int>()))
    }

    @Test
    fun `it returns exact number - if array of int of length 1 is given`() {
        val n = 2
        assertEquals(n.toDouble(), median(arrayOf(n)))
    }

    @Test
    fun `it returns median - if array of int of odd length gt 1 is given`() {
        assertEquals(2.0, median(arrayOf(1, 2, 3)))
    }

    @Test
    fun `it returns median - if array of int of even length gt 1 is given`() {
        assertEquals(1.5, median(arrayOf(1, 2)))
    }

    @Test
    fun `it returns 0 - if empty array of double is passed`() {
        assertEquals(0.0, median(doubleArrayOf()))
    }

    @Test
    fun `it returns exact number - if array of double of length 1 is given`() {
        val n = 2.0
        assertEquals(n.toDouble(), median(doubleArrayOf(n)))
    }

    @Test
    fun `it returns median - if array of double of odd length gt 1 is given`() {
        assertEquals(2.0, median(doubleArrayOf(1.0, 2.0, 3.0)))
    }

    @Test
    fun `it returns median - if array of double of even length gt 1 is given`() {
        assertEquals(1.5, median(doubleArrayOf(1.0, 2.0)))
    }
}
