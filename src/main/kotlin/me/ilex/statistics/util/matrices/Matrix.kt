package me.ilex.statistics.util.matrices

import me.ilex.statistics.exceptions.InvalidArgumentException

class Matrix {
    private var rows: Array<DoubleArray>

    private constructor(rows: Array<DoubleArray>) {
        this.rows = rows
    }

    companion object {
        fun makeFromRows(rows: Array<DoubleArray>): Matrix {
            validateSize(rows)
            return Matrix(rows)
        }

        fun makeFromRows(rows: Array<IntArray>): Matrix {
            //            validateSize(rows)    // @TODO How to use the same validate size method
            // without copying it for different types?
            return Matrix(
                rows.map { row -> row.map { it.toDouble() }.toDoubleArray() }.toTypedArray()
            )
        }

        fun makeFromCols(cols: Array<DoubleArray>): Matrix {
            //            validateSize(cols)
            val rows = Array(cols.size) { DoubleArray(cols.first().size) }
            cols.forEachIndexed { index, doubles -> rows[index] = doubles }
            return makeFromRows(rows)
        }

        private fun validateSize(items: Array<DoubleArray>) {
            if (items.isEmpty()) {
                throw InvalidArgumentException("Passing empty items does not make sense")
            }

            val rowSize = items.first().size

            for (i in items.indices) {
                if (items[i].size != rowSize) {
                    throw InvalidArgumentException(
                        "All the items should be of the same length $rowSize, item with index $i " +
                            "is of length ${items[i].size}"
                    )
                }
            }
        }
    }

    fun toSingleLine(): String {
        return rows.joinToString(" ") { it.joinToString(" ") }
    }

    fun addColumn(col: IntArray): Matrix {
        if (col.size != rows.size) {
            throw InvalidArgumentException(
                "Col size ${col.size} does not match matrix dimension ${rows.size}"
            )
        }

        col.forEachIndexed { index, i -> rows[index] = rows[index].plus(i.toDouble()) }

        return this
    }

    fun addRow(row: IntArray): Matrix {
        val expectedSize = rows.first().size

        if (row.size != expectedSize) {
            throw InvalidArgumentException(
                "Row size ${row.size} does not match matrix dimension $expectedSize"
            )
        }

        rows = rows.plus(row.map { it.toDouble() }.toDoubleArray())
        return this
    }

    fun plus(m: Matrix): Matrix {
        if (rows.size != m.rows.size) {
            throw InvalidArgumentException(
                "Incompatible matrix dimensions: ${rows.size} vs ${m.rows.size}"
            )
        }

        m.rows
            .forEachIndexed { rowIndex, doubles ->
                doubles.forEachIndexed { colIndex, d -> rows[rowIndex][colIndex] += d }
            }

        return this
    }

    fun transpose(): Matrix {
        return makeFromCols(cols())
    }

    fun cols(): Array<DoubleArray> {
        val cols = Array(rows.first().size) { DoubleArray(rows.size) }
        rows.forEachIndexed { rowIndex, doubles ->
            doubles.forEachIndexed { colIndex, d -> cols[colIndex][rowIndex] = d }
        }
        return cols
    }

    fun println() {
        println(rows.joinToString("\n") { it.joinToString(" ") })
    }
}
