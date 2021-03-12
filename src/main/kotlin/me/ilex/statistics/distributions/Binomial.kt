package me.ilex.statistics.distributions

import kotlin.math.pow
import me.ilex.statistics.util.factorial

open class Binomial(protected val amountOfTrials: Int, protected val successProbability: Double) {
    open fun probabilityExact(amountOfSuccesses: Int): Double {
        val nxCombinations = calcNXCombinations(amountOfTrials, amountOfSuccesses)

        return nxCombinations * successProbability.pow(amountOfSuccesses.toDouble()) *
            (1 - successProbability).pow((amountOfTrials - amountOfSuccesses).toDouble())
    }

    fun probabilityAtLeast(amountOfSuccesses: Int): Double {
        var result = 0.0

        for (i in amountOfSuccesses..amountOfTrials) {
            result += probabilityExact(i)
        }

        return result
    }

    fun probabilityAtMost(amountOfSuccesses: Int): Double {
        var result = 0.0

        for (i in 0..amountOfSuccesses) {
            result += probabilityExact(i)
        }

        return result
    }

    protected open fun calcNXCombinations(n: Int, x: Int): Double {
        return factorial(n).toDouble() / (factorial(x) * factorial(n - x)).toDouble()
    }
}
