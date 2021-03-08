package me.ilex.statistics

fun percentile(seq: Array<Double>): Double {
    throw Exception("Not implemented")
}

fun percentile(seq: Array<Int>): Double = percentile(seq.map { it.toDouble() }.toTypedArray())
