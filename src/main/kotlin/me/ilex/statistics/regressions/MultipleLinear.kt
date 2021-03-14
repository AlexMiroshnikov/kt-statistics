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

    constructor(xs: List<DoubleArray>, y: DoubleArray) {
        this.y = y
        this.xs = xs
    }

    //    constructor(vararg args: IntArray) : this(args.map { arg ->
    //            arg.map { it.toDouble() }.toDoubleArray()
    //        }.toTypedArray())

    @Suppress("naming.VariableNaming")
    fun coefs(): Matrix {
        val columnOne = DoubleArray(xs.first().size) { 1.0 }
        val X = Matrix.makeFromCols(arrayOf(columnOne).plus(xs))
        val Y = Matrix.makeFromCols(arrayOf(y))
        val XT = X.transpose()
        return XT.times(X).invert().times(XT).times(Y)
    }
}
