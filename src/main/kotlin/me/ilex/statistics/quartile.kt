package me.ilex.statistics

enum class Quartile {
    FIRST, SECOND, THIRD
}

fun quartile(seq: Array<Double>, quartileNum: Quartile): Double {
    if (seq.isEmpty()) {
        return 0.0
    }

    if (seq.size == 1) {
        return seq.first().toDouble()
    }

    if (quartileNum == Quartile.SECOND) {
        return median(seq)
    }

    seq.sort()

    if (quartileNum == Quartile.FIRST) {
        return median(seq.sliceArray(0 until seq.size / 2))
    }

    var startIndex = seq.size / 2

    if (seq.size % 2 == 1) {
        startIndex++
    }

    return median(seq.sliceArray(startIndex until seq.size))
}

fun quartile(seq: Array<Int>, quartileNum: Quartile): Double =
    quartile(seq.map { it.toDouble() }.toTypedArray(), quartileNum)
