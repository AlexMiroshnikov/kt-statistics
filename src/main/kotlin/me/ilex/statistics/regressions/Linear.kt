package me.ilex.statistics.regressions

import kotlin.math.pow
import me.ilex.statistics.exceptions.InvalidArgumentException
import me.ilex.statistics.mean

class Linear {
    private var x: DoubleArray
    private var y: DoubleArray

    val a: Double
    val b: Double

    constructor(x: DoubleArray, y: DoubleArray) {
        if (x.size != y.size) {
            throw InvalidArgumentException("size of x ${x.size} does not equal size of y ${y.size}")
        }

        this.x = x
        this.y = y

        b = calcB()
        a = calcA()
    }

    constructor(x: IntArray, y: IntArray) :
        this(x.map { it.toDouble() }.toDoubleArray(), y.map { it.toDouble() }.toDoubleArray())

    constructor(xy: Array<Pair<Double, Double>>) :
        this(xy.map { it.first }.toDoubleArray(), xy.map { it.second }.toDoubleArray())

    fun y(x: Double): Double {
        return a + b * x
    }

    fun y(x: Int): Double {
        return y(x.toDouble())
    }

    fun summary(): Nothing = throw NotImplementedError()

    private fun calcB(): Double {
        val sumX = x.sum()
        val denominator = (x.size * x.map { it.pow(2) }.sum() - sumX.pow(2))

        if (denominator == 0.0) {
            return 1.0
        }

        return ((x.size * (x.mapIndexed { index, d -> d * y[index] }).sum()) - sumX * y.sum()) /
            denominator
    }

    private fun calcA(): Double {
        return mean(y) - b * mean(x)
    }
}
