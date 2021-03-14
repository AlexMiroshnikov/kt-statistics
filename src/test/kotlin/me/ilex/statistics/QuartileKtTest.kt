package me.ilex.statistics

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class QuartileKtTest {

    companion object {
        val SEQ_INT_SINGLE = intArrayOf(1)
        val SEQ_INT_ODD = intArrayOf(3, 7, 8, 5, 12, 14, 21, 13)
        val SEQ_INT_EVEN = SEQ_INT_ODD.plus(18)

        val SEQ_DOUBLE_SINGLE = doubleArrayOf(1.0)
        val SEQ_DOUBLE_ODD = doubleArrayOf(3.0, 7.0, 8.0, 5.0, 12.0, 14.0, 21.0, 13.0)
        val SEQ_DOUBLE_EVEN = SEQ_DOUBLE_ODD.plus(18.0)
    }

    @Test
    fun `it returns 0 as 1st quartile - if empty array of int is passed`() {
        assertEquals(0.0, quartile(intArrayOf(), Quartile.FIRST))
    }

    @Test
    fun `it returns 0 as 2nd quartile - if empty array of int is passed`() {
        assertEquals(0.0, quartile(intArrayOf(), Quartile.SECOND))
    }

    @Test
    fun `it returns 0 as 3rd quartile - if empty array of int is passed`() {
        assertEquals(0.0, quartile(intArrayOf(), Quartile.THIRD))
    }

    @Test
    fun `it returns exact number as 1st quartile - if array of int of length 1 is given`() {
        assertEquals(1.0, quartile(SEQ_INT_SINGLE, Quartile.FIRST))
    }

    @Test
    fun `it returns exact number as 2nd quartile - if array of int of length 1 is given`() {
        assertEquals(1.0, quartile(SEQ_INT_SINGLE, Quartile.SECOND))
    }

    @Test
    fun `it returns exact number as 3rd quartile - if array of int of length 1 is given`() {
        assertEquals(1.0, quartile(SEQ_INT_SINGLE, Quartile.THIRD))
    }

    @Test
    fun `it returns 1st quartile - if array of int of even length gt 1 is given`() {
        assertEquals(6.0, quartile(SEQ_INT_EVEN, Quartile.FIRST))
    }

    @Test
    fun `it returns 1st quartile - if array of int of odd length gt 1 is given`() {
        assertEquals(6.0, quartile(SEQ_INT_ODD, Quartile.FIRST))
    }

    @Test
    fun `it returns 2nd quartile - if array of int of even length gt 1 is given`() {
        assertEquals(12.0, quartile(SEQ_INT_EVEN, Quartile.SECOND))
    }

    @Test
    fun `it returns 2nd quartile - if array of int of odd length gt 1 is given`() {
        assertEquals(10.0, quartile(SEQ_INT_ODD, Quartile.SECOND))
    }

    @Test
    fun `it returns 3rd quartile - if array of int of even length gt 1 is given`() {
        assertEquals(16.0, quartile(SEQ_INT_EVEN, Quartile.THIRD))
    }

    @Test
    fun `it returns 3rd quartile - if array of int of odd length gt 1 is given`() {
        assertEquals(13.5, quartile(SEQ_INT_ODD, Quartile.THIRD))
    }

    @Test
    fun `it returns 0 as 1st quartile - if empty array of double is passed`() {
        assertEquals(0.0, quartile(doubleArrayOf(), Quartile.FIRST))
    }

    @Test
    fun `it returns 0 as 2nd quartile - if empty array of double is passed`() {
        assertEquals(0.0, quartile(doubleArrayOf(), Quartile.SECOND))
    }

    @Test
    fun `it returns 0 as 3rd quartile - if empty array of double is passed`() {
        assertEquals(0.0, quartile(doubleArrayOf(), Quartile.THIRD))
    }

    @Test
    fun `it returns exact number as 1st quartile - if array of double of length 1 is given`() {
        assertEquals(1.0, quartile(SEQ_DOUBLE_SINGLE, Quartile.FIRST))
    }

    @Test
    fun `it returns exact number as 2nd quartile - if array of double of length 1 is given`() {
        assertEquals(1.0, quartile(SEQ_DOUBLE_SINGLE, Quartile.SECOND))
    }

    @Test
    fun `it returns exact number as 3rd quartile - if array of double of length 1 is given`() {
        assertEquals(1.0, quartile(SEQ_DOUBLE_SINGLE, Quartile.THIRD))
    }

    @Test
    fun `it returns 1st quartile - if array of double of even length gt 1 is given`() {
        assertEquals(6.0, quartile(SEQ_DOUBLE_EVEN, Quartile.FIRST))
    }

    @Test
    fun `it returns 1st quartile - if array of double of odd length gt 1 is given`() {
        assertEquals(6.0, quartile(SEQ_DOUBLE_ODD, Quartile.FIRST))
    }

    @Test
    fun `it returns 2nd quartile - if array of double of even length gt 1 is given`() {
        assertEquals(12.0, quartile(SEQ_DOUBLE_EVEN, Quartile.SECOND))
    }

    @Test
    fun `it returns 2nd quartile - if array of double of odd length gt 1 is given`() {
        assertEquals(10.0, quartile(SEQ_DOUBLE_ODD, Quartile.SECOND))
    }

    @Test
    fun `it returns 3rd quartile - if array of double of even length gt 1 is given`() {
        assertEquals(16.0, quartile(SEQ_DOUBLE_EVEN, Quartile.THIRD))
    }

    @Test
    fun `it returns 3rd quartile - if array of double of odd length gt 1 is given`() {
        assertEquals(13.5, quartile(SEQ_DOUBLE_ODD, Quartile.THIRD))
    }
}
