package me.ilex.statistics.tools

import java.math.BigInteger
import me.ilex.statistics.exceptions.InvalidArgumentException
import me.ilex.statistics.mean
import me.ilex.statistics.stdDeviation

class PearsonCorrelation {

    private var x: Array<Double>
    private var y: Array<Double>

    private var means: Pair<Double, Double>

    constructor(x: Array<Double>, y: Array<Double>) {
        if (x.size != y.size)
            throw InvalidArgumentException(
                "Size of x and y must be the same, sizes ${x.size} and ${y.size} were given"
            )

        this.x = x
        this.y = y

        means = Pair(mean(x), mean(y))
    }

    constructor(x: Array<Int>, y: Array<Int>) :
        this(x.map { it.toDouble() }.toTypedArray(), y.map { it.toDouble() }.toTypedArray())

    constructor(x: Array<Double>, y: Array<Int>) : this(x, y.map { it.toDouble() }.toTypedArray())

    constructor(x: Array<Int>, y: Array<Double>) : this(x.map { it.toDouble() }.toTypedArray(), y)

    constructor(x: Array<BigInteger>, y: Array<BigInteger>) :
        this(x.map { it.toDouble() }.toTypedArray(), y.map { it.toDouble() }.toTypedArray())

    fun covariance(): Double {
        var result = 0.0

        if (x.isEmpty()) {
            return result
        }

        val (xMean, yMean) = means

        for (i in x.indices) {
            result += (x[i] - xMean) * (y[i] - yMean)
        }

        result /= x.size

        return result
    }

    fun correlationCoef(): Double {
        val denominator = stdDeviation(x) * stdDeviation(y)

        if (denominator == 0.0) {
            return 1.0
        }

        return covariance() / denominator
    }
}