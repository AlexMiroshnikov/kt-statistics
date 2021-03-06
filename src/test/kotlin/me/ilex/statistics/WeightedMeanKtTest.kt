package me.ilex.statistics

import me.ilex.statistics.exceptions.InvalidArgumentException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class WeightedMeanKtTest {

    @Test
    fun `it returns weighted mean - if array of int of length gt 1 is given and weights are double`() {
        assertEquals(
            32.0,
            weightedMean(arrayOf(10, 40, 30, 50, 20), arrayOf(1.0, 2.0, 3.0, 4.0, 5.0))
        )
    }

    @Test
    fun `it returns weighted mean - if array of int of length gt 1 is given and weights are int`() {
        assertEquals(32.0, weightedMean(arrayOf(10, 40, 30, 50, 20), arrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun `it returns weighted mean - if array of double of length gt 1 is given and weights are int`() {
        assertEquals(
            32.0,
            weightedMean(arrayOf(10.0, 40.0, 30.0, 50.0, 20.0), arrayOf(1, 2, 3, 4, 5))
        )
    }

    @Test
    fun `it returns weighted mean - if array of double of length gt 1 is given and weights are double`() {
        assertEquals(
            32.0,
            weightedMean(arrayOf(10.0, 40.0, 30.0, 50.0, 20.0), arrayOf(1.0, 2.0, 3.0, 4.0, 5.0))
        )
    }

    @Test
    fun `it returns 0 - if empty array of double is given`() {
        assertEquals(0.0, weightedMean(emptyArray<Double>(), emptyArray<Double>()))
    }

    @Test
    fun `it throws an exception - if length of sequence does not equal length of weights`() {
        assertThrows<InvalidArgumentException> { weightedMean(arrayOf(1.0), emptyArray<Double>()) }
    }

    @Test
    fun `it throws an exception - if length of weights does not equal length of sequence`() {
        assertThrows<InvalidArgumentException> { weightedMean(emptyArray<Double>(), arrayOf(1.0)) }
    }
}
