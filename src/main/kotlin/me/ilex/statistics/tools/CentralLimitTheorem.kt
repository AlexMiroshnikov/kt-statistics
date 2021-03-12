package me.ilex.statistics.tools

import me.ilex.statistics.distributions.Normal
import kotlin.math.sqrt

class CentralLimitTheorem(private val expectation: Double, private val variance: Double) {
    fun predict(n: Double, x: Double): Double {
        val d = Normal.makeThroughVariance(n * expectation, sqrt(n) * variance)
        return d.probabilityDensity(x)
    }
}
