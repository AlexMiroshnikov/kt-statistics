package me.ilex.statistics.util.matrices

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MatrixTest {

    @Test
    fun `toSingleLine - returns expected data`() {
        val m = Matrix.makeFromRows(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)))
        assertEquals("1.0 2.0 3.0 4.0", m.toSingleLine())
    }

    @Test
    fun `addColumn - appends column to the end`() {
        val m = Matrix.makeFromRows(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)))
        m.addColumn(intArrayOf(5, 6))
        assertEquals("1.0 2.0 5.0 3.0 4.0 6.0", m.toSingleLine())
    }

    @Test
    fun `addRow - appends row to the end`() {
        val m = Matrix.makeFromRows(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)))
        m.addRow(intArrayOf(5, 6))
        assertEquals("1.0 2.0 3.0 4.0 5.0 6.0", m.toSingleLine())
    }

    @Test
    fun `plus - returns expected result`() {
        val m1 = Matrix.makeFromRows(arrayOf(intArrayOf(1, 2)))
        val m2 = Matrix.makeFromRows(arrayOf(intArrayOf(3, 4)))
        m1.plus(m2)
        assertEquals("4.0 6.0", m1.toSingleLine())
    }

    @Test
    fun `transpose - returns expected result`() {
        val m = Matrix.makeFromRows(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4), intArrayOf(5, 6)))

        val t = m.transpose()

        assertEquals("1.0 3.0 5.0 2.0 4.0 6.0", t.toSingleLine())
    }
}
