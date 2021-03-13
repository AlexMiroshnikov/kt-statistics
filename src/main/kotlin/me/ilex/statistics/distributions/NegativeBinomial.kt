package me.ilex.statistics.distributions

open class NegativeBinomial(amountOfTrials: Int, successProbability: Double) :
    Binomial(amountOfTrials, successProbability) {

    override fun calcNXCombinations(n: Int, x: Int): Double {
        return super.calcNXCombinations(n - 1, x - 1)
    }
}
