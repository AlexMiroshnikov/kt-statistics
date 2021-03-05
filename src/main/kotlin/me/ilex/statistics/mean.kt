package me.ilex.statistics

fun mean(seq: Array<Int>): Double {
    if (seq.isEmpty()) {
        return 0.0
    }

    return seq.average()
}
