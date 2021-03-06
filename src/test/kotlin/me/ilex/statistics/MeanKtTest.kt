package me.ilex.statistics

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MeanKtTest {

    @Test
    fun `it returns 0 - if empty array of int is passed`() {
        assertEquals(0.0, mean(intArrayOf()))
    }

    @Test
    fun `it returns exact number - if array of int length 1 is given`() {
        val n = 2
        assertEquals(n.toDouble(), mean(intArrayOf(n)))
    }

    @Test
    fun `it returns mean - if array of int of length gt 1 is given`() {
        assertEquals(1.5, mean(intArrayOf(1, 2)))
    }

    @Test
    fun `it returns 0 - if empty array of double is passed`() {
        assertEquals(0.0, mean(doubleArrayOf()))
    }

    @Test
    fun `it returns exact number - if array of double length 1 is given`() {
        val n = 2.0
        assertEquals(n, mean(doubleArrayOf(n)))
    }

    @Test
    fun `it returns mean - if array of double of length gt 1 is given`() {
        assertEquals(1.5, mean(doubleArrayOf(1.0, 2.0)))
    }
}
