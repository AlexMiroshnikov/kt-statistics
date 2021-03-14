package me.ilex.statistics

import kotlin.math.ceil
import kotlin.math.floor

fun median(seq: DoubleArray): Double {
    if (seq.isEmpty()) {
        return 0.0
    }

    if (seq.size == 1) {
        return seq.first().toDouble()
    }

    seq.sort()

    if (seq.size % 2 == 0) {
        return arrayOf(
            seq[floor((seq.size / 2).toDouble() - 1).toInt()],
            seq[ceil((seq.size / 2).toDouble()).toInt()]
        ).average()
    }

    return seq[floor((seq.size / 2).toDouble()).toInt()]
}

fun median(seq: IntArray): Double = median(seq.map { it.toDouble() }.toDoubleArray())
