package me.ilex.statistics

import kotlin.math.pow
import kotlin.math.sqrt

fun stdDeviation(seq: DoubleArray): Double {
    if (seq.isEmpty()) {
        return 0.0
    }

    val mean = mean(seq)
    val sumOfSquaredDistances = seq.map { (it - mean).pow(2) }.sum()
    return sqrt(sumOfSquaredDistances / seq.size)
}

fun stdDeviation(seq: IntArray): Double = stdDeviation(seq.map { it.toDouble() }.toDoubleArray())
