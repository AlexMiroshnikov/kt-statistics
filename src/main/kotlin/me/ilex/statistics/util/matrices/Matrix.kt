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
            cols.forEachIndexed { colIndex, colValues ->
                colValues.forEachIndexed { rowIndex, d ->
                    rows[rowIndex][colIndex] = d
                }
            }
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

    fun times(m: Matrix): Matrix {
        val mCols = m.cols()
        val newRows = Array(rows.size) { DoubleArray(mCols.size) }
        rows.forEachIndexed { rowIndex, doubles ->
            mCols.indices
                .forEach { colIndex ->
                    newRows[rowIndex][colIndex] = calcTimesForIJ(doubles, mCols[colIndex])
                }
        }
        return Matrix(newRows)
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

    fun dimensions(): Pair<Int, Int> {
        return Pair(rows.size, rows.first().size)
    }

    fun isSquare(): Boolean {
        val (d1, d2) = dimensions()
        return d1 == d2
    }

    fun invert(): Matrix {
        validateIfIsSquare()
        return makeFromRows(emptyArray<DoubleArray>())
    }

    fun determinant(): Double {
        validateIfIsSquare()

        if (dimensions().first == 2) {
            return rows[0][0] * rows[1][1] - rows[0][1] * rows[1][0]
        }

        var result = 0.0
        var d: Double
        var m: Matrix

        rows[0].forEachIndexed { colIndex, value ->
            var c = cols().toList()
            println("\n\nIteration\n")
            println("original cols of $colIndex")
            c.map {
                println(it.toList())
            }
            c = c.filterIndexed { index, _ -> index != colIndex }
            println("filtered cols of $colIndex")
            c.map {
                println(it.toList())
            }
            c = c.map {
                it.drop(1).toDoubleArray()
            }
            println("DROPPED cols of $colIndex")
            c.map {
                println(it.toList())
            }
            m = makeFromCols(c.toTypedArray())
            println("GOT MATRIX:")
            m.println()
//            m = makeFromCols(cols().filterIndexed { index, _ -> index != colIndex }.map {
//                it.drop(1).toDoubleArray()
//            }.toTypedArray())

            d = value * m.determinant()

            if (colIndex % 2 != 0) {
                d = -d
            }

//            println("* $value x")
//            m.println()

            result += d
        }

        return result
    }

    fun println() {
        println(rows.joinToString("\n") { it.joinToString(" ") })
    }

    private fun calcTimesForIJ(row: DoubleArray, col: DoubleArray): Double {
        var result = 0.0

        for (i in row.indices) {
            result += (row[i] * col[i])
        }

        return result
    }

    private fun validateIfIsSquare() {
        if (!isSquare()) {
            val (d1, d2) = dimensions()
            throw Exception("Only square matrices can be inverted, while actual dimensions are ${d1}x${d2}")
        }
    }
}
