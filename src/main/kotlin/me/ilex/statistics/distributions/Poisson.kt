package me.ilex.statistics.distributions

import kotlin.math.E
import kotlin.math.pow
import me.ilex.statistics.util.factorial

class Poisson(private val avgAmountOfSuccesses: Double) {

    fun probabilityExact(amountOfSuccesses: Int): Double {
        return avgAmountOfSuccesses.pow(amountOfSuccesses) * E.pow(-avgAmountOfSuccesses) /
            factorial(amountOfSuccesses).toDouble()
    }

    fun probabilityAtMost(amountOfSuccesses: Int): Double {
        var result = 0.0

        for (i in 0..amountOfSuccesses) {
            result += probabilityExact(i)
        }

        return result
    }
}
