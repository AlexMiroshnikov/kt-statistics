package me.ilex.statistics

fun interquartileRange(seq: Array<Double>): Double {
    return quartile(seq, Quartile.THIRD) - quartile(seq, Quartile.FIRST)
}

fun interquartileRange(seq: Array<Int>): Double {
    return interquartileRange(seq.map { it.toDouble() }.toTypedArray())
}
