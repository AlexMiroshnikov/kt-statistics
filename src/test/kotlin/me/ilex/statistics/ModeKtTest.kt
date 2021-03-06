package me.ilex.statistics

import kotlin.test.assertEquals
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

internal class ModeKtTest {

    @Test
    fun `it returns only one mode - when there is only one mode of type int`() {
        assertArrayEquals(intArrayOf(3), mode(intArrayOf(1, 2, 3, 3)))
    }

    @Test
    fun `it returns several modes - when there is more than one mode of type int`() {
        assertArrayEquals(intArrayOf(6, 9), mode(intArrayOf(6, 2, 6, 6, 8, 9, 9, 9, 0)))
    }

    @Test
    fun `it returns only one mode - when there is only one mode of type double`() {
        assertArrayEquals(doubleArrayOf(3.0), mode(doubleArrayOf(1.0, 2.0, 3.0, 3.0)))
    }

    @Test
    fun `it returns several modes - when there is more than one mode of type double`() {
        assertArrayEquals(
            doubleArrayOf(6.0, 9.0),
            mode(doubleArrayOf(6.0, 2.0, 6.0, 6.0, 8.0, 9.0, 9.0, 9.0, 0.0))
        )
    }

    @Test
    fun `it returns empty array - when empty array is given`() {
        assertEquals(0, mode(intArrayOf()).size)
    }
}
