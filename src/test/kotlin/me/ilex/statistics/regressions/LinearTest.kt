package me.ilex.statistics.regressions

import me.ilex.statistics.exceptions.InvalidArgumentException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LinearTest {

    @Test
    fun `it calculates a and b correctly`() {
        val r = Linear(arrayOf(1, 2, 3, 4, 5), arrayOf(2, 1, 4, 3, 5))
        assertEquals(0.8, r.b)
        assertEquals(0.5999999999999996, r.a)
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
}
