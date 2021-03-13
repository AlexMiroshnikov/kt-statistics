package me.ilex.statistics.regressions

import me.ilex.statistics.exceptions.InvalidArgumentException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LinearTest {

    private companion object {
        val X = arrayOf(1, 2, 3, 4, 5)
        val Y = arrayOf(2, 1, 4, 3, 5)

        const val a = 0.5999999999999996
        const val b = 0.8
    }

    @Test
    fun `it calculates a and b correctly - when constructed through separate arrays`() {
        val r = Linear(X, Y)
        assertEquals(b, r.b)
        assertEquals(a, r.a)
    }

    @Test
    fun `it calculates a and b correctly - when constructed through array of pairs`() {
        val r =
            Linear(
                X.mapIndexed { index, i -> Pair(i.toDouble(), Y[index].toDouble()) }.toTypedArray()
            )
        assertEquals(b, r.b)
        assertEquals(a, r.a)
    }

    @Test
    fun `summary throws an exception`() {
        val r = Linear(arrayOf(1), arrayOf(1))
        assertThrows<NotImplementedError> { r.summary() }
    }

    @Test
    fun `constructor throws an exception - when size of x does not equal size of y`() {
        assertThrows<InvalidArgumentException> { Linear(arrayOf(1), arrayOf()) }
        assertThrows<InvalidArgumentException> { Linear(arrayOf(), arrayOf(1)) }
    }

    @Test
    fun `it calculates expected y basing on given x`() {
        val r = Linear(arrayOf(Pair(1.0, 1.0)))
        val expected = 2.0
        assertEquals(expected, r.y(2.0))
        assertEquals(expected, r.y(2))
    }
}
