package me.ilex.statistics.distributions

import kotlin.math.E
import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.sqrt

class Normal(private val expectation: Double, private val stdDeviation: Double) {

    companion object {
        fun makeThroughDeviation(expectation: Double, stdDeviation: Double): Normal {
            return Normal(expectation, stdDeviation)
        }

        fun makeThroughVariance(expectation: Double, variance: Double): Normal {
            return makeThroughDeviation(expectation, sqrt(variance))
        }
    }

    fun probabilityDensity(x: Double): Double {
        return 1.0 / (stdDeviation * sqrt(2 * PI)) *
            E.pow(-(x - expectation).pow(2) / (2 * stdDeviation.pow(2)))
    }
}
