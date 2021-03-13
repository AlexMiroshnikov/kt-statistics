package me.ilex.statistics.tools

import me.ilex.statistics.rank

class Spearman {
    companion object {
        fun rankCorrelationCoef(x: Array<Double>, y: Array<Double>): Double {
            return PearsonCorrelation(rank(x), rank(y)).correlationCoef()
        }
    }
}
