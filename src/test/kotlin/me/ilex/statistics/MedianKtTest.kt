package me.ilex.statistics

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MedianKtTest {

    @Test
    fun `it returns 0 - if empty array is passed`() {
        assertEquals(0.0, median(emptyArray()))
    }

    @Test
    fun `it returns exact number - if array of length 1 is given`() {
        val n = 2
        assertEquals(n.toDouble(), median(arrayOf(n)))
    }

    @Test
    fun `it returns median - if array of odd length gt 1 is given`() {
        assertEquals(2.0, mean(arrayOf(1, 2, 3)))
    }

    @Test
    fun `it returns median - if array of even length gt 1 is given`() {
        assertEquals(1.5, mean(arrayOf(1, 2)))
    }
}
