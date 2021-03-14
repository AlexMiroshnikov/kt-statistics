package me.ilex.statistics.regressions

import me.ilex.statistics.exceptions.InvalidArgumentException
import me.ilex.statistics.util.matrices.Matrix

class MultipleLinear {

    private var y: DoubleArray
    private var xs: List<DoubleArray>

    constructor(vararg args: DoubleArray) {
        if (args.size < 2) {
            throw InvalidArgumentException(
                "There must be at least 2 args (X and Y), ${args.size} was given"
            )
        }

        y = args.last()
        xs = args.slice(IntRange(0, args.size - 2))
    }

    //    constructor(vararg args: IntArray) : this(args.map { arg ->
    //            arg.map { it.toDouble() }.toDoubleArray()
    //        }.toTypedArray())

    fun coefs(): Matrix {
        //        println("y:\n" + y.toList())
        val Y = Matrix.makeFromCols(arrayOf(y))
        val xRows = xs.map { doubleArrayOf(1.0).plus(it) }.toTypedArray()
        val X = Matrix.makeFromRows(xRows)
        val XT = X.transpose()
        val XTtimesX = XT.times(X)
        println(XTtimesX.dimensions())
        return Matrix.makeFromCols(Y.cols())
    }
}
