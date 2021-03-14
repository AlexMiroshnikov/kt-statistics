package me.ilex.statistics

fun interquartileRange(seq: DoubleArray): Double {
    return quartile(seq, Quartile.THIRD) - quartile(seq, Quartile.FIRST)
}

fun interquartileRange(seq: IntArray): Double {
    return interquartileRange(seq.map { it.toDouble() }.toDoubleArray())
}
