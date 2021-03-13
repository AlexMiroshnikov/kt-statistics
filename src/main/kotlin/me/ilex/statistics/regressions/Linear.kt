package me.ilex.statistics.regressions

import java.math.BigInteger
import kotlin.math.pow
import me.ilex.statistics.exceptions.InvalidArgumentException
import me.ilex.statistics.mean

class Linear {
    private var x: Array<Double>
    private var y: Array<Double>

    val a: Double
    val b: Double

    constructor(x: Array<Double>, y: Array<Double>) {
        if (x.size != y.size) {
            throw InvalidArgumentException("size of x ${x.size} does not equal size of y ${y.size}")
        }

        this.x = x
        this.y = y

        b = calcB()
        a = calcA()
    }

    constructor(x: Array<BigInteger>, y: Array<BigInteger>) :
        this(x.map { it.toDouble() }.toTypedArray(), y.map { it.toDouble() }.toTypedArray())

    constructor(x: Array<Int>, y: Array<Int>) :
        this(x.map { it.toDouble() }.toTypedArray(), y.map { it.toDouble() }.toTypedArray())

    constructor(xy: Array<Pair<Double, Double>>) :
        this(xy.map { it.first }.toTypedArray(), xy.map { it.second }.toTypedArray())

    fun summary(): Nothing = throw NotImplementedError()

    private fun calcB(): Double {
        val sumX = x.sum()
        return ((x.size * (x.mapIndexed { index, d -> d * y[index] }).sum()) - sumX * y.sum()) /
            (x.size * x.map { it.pow(2) }.sum() - sumX.pow(2))
    }

    private fun calcA(): Double {
        return mean(y) - b * mean(x)
    }
}
