package me.ilex.statistics

enum class Quartile {
    FIRST, SECOND, THIRD
}

fun quartile(seq: Array<Int>, quartileNum: Quartile): Double {
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
        return median(seq.sliceArray(0 until seq.size/2))
    }

    return median(seq.sliceArray(seq.size/2 + 1 until seq.size))
}
