package me.ilex.statistics

fun mode(seq: DoubleArray): DoubleArray {
    if (seq.isEmpty()) {
        return doubleArrayOf()
    }

    val modes = seq.toTypedArray().groupingBy { it }.fold(0) { count, _ -> count + 1 }
    val maxMode = modes.values.maxOrNull() ?: return doubleArrayOf()

    return modes.filter { it.value == maxMode }.keys.toDoubleArray().sortedArray()
}

fun mode(seq: IntArray): IntArray =
    mode(seq.map { it.toDouble() }.toDoubleArray()).map { it.toInt() }.toIntArray()
