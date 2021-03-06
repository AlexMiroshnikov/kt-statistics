package me.ilex.statistics

fun mode(seq: Array<Double>): Array<Double> {
    if (seq.isEmpty()) {
        return emptyArray()
    }

    val modes = mutableMapOf<Double, Int>()

    seq.forEach {
        if (!modes.containsKey(it)) {
            modes[it] = 0
        }
        modes[it]?.plus(1)?.let { it1 -> modes[it] = it1 }
    }

    val maxMode = modes.values.maxOrNull()

    return modes.filter { it.value == maxMode }.keys.toTypedArray()
}

fun mode(seq: Array<Int>): Array<Int> =
    mode(seq.map { it.toDouble() }.toTypedArray()).map { it.toInt() }.toTypedArray()
