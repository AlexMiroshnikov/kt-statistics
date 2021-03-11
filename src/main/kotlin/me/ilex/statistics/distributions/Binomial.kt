package me.ilex.statistics.distributions

import java.math.BigInteger
import kotlin.math.pow

class Binomial(private val amountOfTrials: Int, private val successProbability: Double) {
    fun probabilityExact(amountOfSuccesses: Int): Double {
        val nxCombinations =
            factorial(amountOfTrials).toDouble() /
                (factorial(amountOfSuccesses) * factorial(amountOfTrials - amountOfSuccesses))
                    .toDouble()

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

    private fun factorial(num: Int): BigInteger {
        var result = BigInteger.ONE

        if (num >= 2) {
            for (i in 2..num) {
                result *= i.toBigInteger()
            }
        }

        return result
    }
}
