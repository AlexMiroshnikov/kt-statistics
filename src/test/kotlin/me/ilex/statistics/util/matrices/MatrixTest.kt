package me.ilex.statistics.util.matrices

import java.io.ByteArrayOutputStream
import java.io.PrintStream
import me.ilex.statistics.exceptions.InvalidArgumentException
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class MatrixTest {

    private val standardOut = System.out
    private val outputStreamCaptor = ByteArrayOutputStream()

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
    }

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
    fun `addColumn - throws an exception - when column of unexpected size is given`() {
        val m = Matrix.makeFromRows(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)))
        assertThrows<InvalidArgumentException> { m.addColumn(intArrayOf(5)) }
    }

    @Test
    fun `addRow - appends row to the end`() {
        val m = Matrix.makeFromRows(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)))
        m.addRow(intArrayOf(5, 6))
        assertEquals("1.0 2.0 3.0 4.0 5.0 6.0", m.toSingleLine())
    }

    @Test
    fun `addRow - throws an exception - when row of unexpected size is given`() {
        val m = Matrix.makeFromRows(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)))
        assertThrows<InvalidArgumentException> { m.addRow(intArrayOf(5)) }
    }

    @Test
    fun `plus - returns expected result`() {
        val m1 = Matrix.makeFromRows(arrayOf(intArrayOf(1, 2)))
        val m2 = Matrix.makeFromRows(arrayOf(intArrayOf(3, 4)))
        m1.plus(m2)
        assertEquals("4.0 6.0", m1.toSingleLine())
    }
    @Test
    fun `plus - throws an exception - when arg has unexpected rows length`() {
        val m1 = Matrix.makeFromRows(arrayOf(intArrayOf(1)))
        val m2 = Matrix.makeFromCols(arrayOf(doubleArrayOf(2.0, 3.0)))
        assertThrows<InvalidArgumentException> { m1.plus(m2) }
    }

    @Test
    fun `plus - throws an exception - when arg has unexpected cols length`() {
        val m1 = Matrix.makeFromRows(arrayOf(intArrayOf(1)))
        val m2 = Matrix.makeFromRows(arrayOf(intArrayOf(1, 2)))
        assertThrows<InvalidArgumentException> { m1.plus(m2) }
    }

    @Test
    fun `transpose - returns expected result`() {
        val m = Matrix.makeFromRows(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4), intArrayOf(5, 6)))
        val t = m.transpose()
        assertEquals("1.0 3.0 5.0 2.0 4.0 6.0", t.toSingleLine())
    }

    @Test
    fun `times - returns expected result`() {
        val a =
            Matrix.makeFromRows(
                arrayOf(intArrayOf(2, 3, 4), intArrayOf(1, 2, 0), intArrayOf(2, 3, 1))
            )
        val b = Matrix.makeFromRows(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4), intArrayOf(5, 6)))
        val m = a.times(b)
        assertEquals("31.0 40.0 7.0 10.0 16.0 22.0", m.toSingleLine())
    }

    @Test
    fun `makeFromCols - returns expected result`() {
        val m =
            Matrix.makeFromCols(
                arrayOf(
                    doubleArrayOf(-2.0, 1.0, 1.0),
                    doubleArrayOf(1.0, 3.0, 1.0),
                    doubleArrayOf(-1.0, 1.0, -4.0)
                )
            )
        assertEquals("-2.0 1.0 -1.0 1.0 3.0 1.0 1.0 1.0 -4.0", m.toSingleLine())
    }

    @Test
    fun `determinant - returns expected result`() {
        listOf(
            Pair(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)), -2.0),
            Pair(arrayOf(intArrayOf(1, 4, 3), intArrayOf(2, 1, 5), intArrayOf(3, 2, 1)), 46.0),
            Pair(
                arrayOf(
                    intArrayOf(4, 3, 2, 2),
                    intArrayOf(0, 1, -3, 3),
                    intArrayOf(0, -1, 3, 3),
                    intArrayOf(0, 3, 1, 1)
                ),
                -240.0
            )
        )
            .forEach {
                val (rows, expected) = it
                val m = Matrix.makeFromRows(rows)
                assertEquals(expected, m.determinant())
            }
    }

    @Test
    fun `minor - returns expected result`() {
        val m =
            Matrix.makeFromRows(
                arrayOf(
                    intArrayOf(1, 0, 0, 0),
                    intArrayOf(3, 1, 0, 0),
                    intArrayOf(-5, 2, 1, 0),
                    intArrayOf(7, -3, 2, 1)
                )
            )

        assertEquals("1.0 0.0 0.0 2.0 1.0 0.0 -3.0 2.0 1.0", m.getMinor(0, 0).toSingleLine())
        assertEquals("1.0 0.0 0.0 3.0 1.0 0.0 -5.0 2.0 1.0", m.getMinor(3, 3).toSingleLine())
    }

    @Test
    fun `invert - returns expected result`() {
        val m =
            Matrix.makeFromRows(
                arrayOf(
                    intArrayOf(1, 3, -5, 7),
                    intArrayOf(0, 1, 2, -3),
                    intArrayOf(0, 0, 1, 2),
                    intArrayOf(0, 0, 0, 1)
                )
            )
        val i = m.invert()
        assertEquals(
            "1.0 -3.0 11.0 -38.0 0.0 1.0 -2.0 7.0 0.0 0.0 1.0 -2.0 0.0 0.0 0.0 1.0",
            i.toSingleLine()
        )
    }

    @Test
    fun `constructor throws an exception - when empty array is passed`() {
        assertThrows<InvalidArgumentException> { Matrix.makeFromRows(emptyArray<DoubleArray>()) }
    }

    @Test
    fun `constructor throws an exception - when array members have unequal sizes`() {
        assertThrows<InvalidArgumentException> {
            Matrix.makeFromRows(arrayOf(doubleArrayOf(1.0), doubleArrayOf(1.0, 2.0)))
        }
    }

    @Test
    fun `println returns expected output`() {
        System.setOut(PrintStream(outputStreamCaptor))
        val m = Matrix.makeFromRows(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)))
        m.println()
        assertEquals("1.0 2.0\n3.0 4.0", outputStreamCaptor.toString().trim())
    }

    @Test
    fun `determinant on not square matrix throws an exception`() {
        val m = Matrix.makeFromRows(arrayOf(intArrayOf(1, 2)))
        assertThrows<Exception> { m.determinant() }
    }
}
