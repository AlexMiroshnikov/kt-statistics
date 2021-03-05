package me.ilex.statistics

import kotlin.math.ceil
import kotlin.math.floor

fun median(seq: Array<Int>): Double {
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
            seq[ceil((seq.size / 2).toDouble()).toInt()],
        ).average()
    }

    return seq[seq.size / 2 - 1].toDouble()
}
