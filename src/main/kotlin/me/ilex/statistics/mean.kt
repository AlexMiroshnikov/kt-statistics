package me.ilex.statistics

fun mean(seq: Array<Double>): Double {
    if (seq.isEmpty()) {
        return 0.0
    }

    return seq.average()
}

fun mean(seq: Array<Int>): Double = mean(seq.map { it.toDouble() }.toTypedArray())
