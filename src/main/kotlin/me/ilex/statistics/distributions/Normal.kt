package me.ilex.statistics.distributions

import kotlin.math.E
import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.sqrt
import me.ilex.statistics.util.Erf

class Normal(private val expectation: Double, private val stdDeviation: Double) {

    companion object {
        fun makeThroughDeviation(expectation: Double, stdDeviation: Double): Normal {
            return Normal(expectation, stdDeviation)
        }

        fun makeThroughVariance(expectation: Double, variance: Double): Normal {
            return makeThroughDeviation(expectation, sqrt(variance))
        }

        private val SQRT_FROM_2 = sqrt(2.0)
    }

    fun probabilityDensity(x: Double): Double {
        return 1.0 / (stdDeviation * sqrt(2 * PI)) *
            E.pow(-(x - expectation).pow(2) / (2 * stdDeviation.pow(2)))
    }

    fun cumulativeProbability(x: Double): Double {
        return 0.5 * (1 + Erf.calc((x - expectation) / (stdDeviation * SQRT_FROM_2)))
    }
}
