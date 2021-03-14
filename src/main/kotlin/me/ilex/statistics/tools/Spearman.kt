package me.ilex.statistics.tools

import me.ilex.statistics.rank

object Spearman {
    fun rankCorrelationCoef(x: DoubleArray, y: DoubleArray): Double {
        return PearsonCorrelation(rank(x), rank(y)).correlationCoef()
    }
}
