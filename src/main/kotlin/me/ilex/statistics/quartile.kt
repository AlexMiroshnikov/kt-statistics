@file:Suppress("MatchingDeclarationName", "ReturnCount")

package me.ilex.statistics

enum class Quartile {
    FIRST, SECOND, THIRD
}

fun quartile(seq: DoubleArray, quartileNum: Quartile): Double {
    if (seq.isEmpty()) {
        return 0.0
    }

    if (seq.size == 1) {
        return seq.first()
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

fun quartile(seq: IntArray, quartileNum: Quartile): Double =
    quartile(seq.map { it.toDouble() }.toDoubleArray(), quartileNum)
