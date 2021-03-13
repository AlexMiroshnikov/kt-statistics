package me.ilex.statistics.tools

import kotlin.math.sqrt
import me.ilex.statistics.distributions.Normal

class CentralLimitTheorem(private val expectation: Double, private val stdDeviation: Double) {
    fun probability(n: Double, x: Double): Double {
        val d = Normal.makeThroughDeviation(n * expectation, sqrt(n) * stdDeviation)
        return d.cumulativeProbability(x)
    }

    fun predictionInterval(z: Double): Pair<Double, Double> {
        return Pair(expectation - z * stdDeviation, expectation + z * stdDeviation)
    }
}
