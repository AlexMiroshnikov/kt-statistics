package me.ilex.statistics

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MeanKtTest {

    @Test
    fun `it returns 0 - if empty array is passed`() {
        assertEquals(0.0, mean(emptyArray()))
    }

    @Test
    fun `it returns exact number - if array of length 1 is given`() {
        val n = 2
        assertEquals(n.toDouble(), mean(arrayOf(n)))
    }

    @Test
    fun `it returns mean - if array of length gt 1 is given`() {
        assertEquals(1.5, mean(arrayOf(1, 2)))
    }
}
