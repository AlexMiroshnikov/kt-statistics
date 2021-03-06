package me.ilex.statistics

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class QuartileKtTest {

    companion object {
        val SEQ_INT_SINGLE = arrayOf(1)
        val SEQ_INT_ODD = arrayOf(3, 7, 8, 5, 12, 14, 21, 13)
        val SEQ_INT_EVEN = SEQ_INT_ODD.plusElement(18)
    }

    @Test
    fun `it returns 0 as 1st quartile - if empty array of int is passed`() {
        assertEquals(0.0, quartile(arrayOf<Int>(), Quartile.FIRST))
    }

    @Test
    fun `it returns 0 as 2nd quartile - if empty array of int is passed`() {
        assertEquals(0.0, quartile(arrayOf<Int>(), Quartile.SECOND))
    }

    @Test
    fun `it returns 0 as 3rd quartile - if empty array of int is passed`() {
        assertEquals(0.0, quartile(arrayOf<Int>(), Quartile.THIRD))
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
}
