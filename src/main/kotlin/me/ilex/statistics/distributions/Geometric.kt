package me.ilex.statistics.distributions

import kotlin.math.pow

open class Geometric(amountOfTrials: Int, successProbability: Double) :
    NegativeBinomial(amountOfTrials, successProbability) {

    override fun probabilityExact(amountOfSuccesses: Int): Double {
        return (1 - successProbability).pow((amountOfTrials - 1).toDouble()) * successProbability
    }
}
