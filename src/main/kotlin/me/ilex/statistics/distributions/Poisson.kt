package me.ilex.statistics.distributions

import java.math.BigInteger
import kotlin.math.E
import kotlin.math.pow

class Poisson(private val avgAmountOfSuccesses: Int) {

    fun probabilityExact(amountOfSuccesses: Int): Double {
        return avgAmountOfSuccesses.toDouble().pow(amountOfSuccesses) *
            E.pow(-avgAmountOfSuccesses) / factorial(amountOfSuccesses).toDouble()
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
