package me.ilex.statistics

fun mode(seq: Array<Double>): Array<Double> {
    if (seq.isEmpty()) {
        return emptyArray()
    }

    val modes = seq.groupingBy { it }.fold(0) { count, _ -> count + 1 }
    val maxMode = modes.values.maxOrNull() ?: return emptyArray()

    return modes.filter { it.value == maxMode }.keys.toTypedArray().sortedArray()
}

fun mode(seq: Array<Int>): Array<Int> =
    mode(seq.map { it.toDouble() }.toTypedArray()).map { it.toInt() }.toTypedArray()
