package me.ilex.statistics

fun mean(seq: DoubleArray): Double {
    if (seq.isEmpty()) {
        return 0.0
    }

    return seq.average()
}

fun mean(seq: Array<Int>): Double = mean(seq.map { it.toDouble() }.toDoubleArray())
