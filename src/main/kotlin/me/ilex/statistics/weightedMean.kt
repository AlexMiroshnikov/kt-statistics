package me.ilex.statistics

import me.ilex.statistics.exceptions.InvalidArgumentException

fun weightedMean(seq: DoubleArray, weights: DoubleArray): Double {
    if (seq.size != weights.size) {
        throw InvalidArgumentException(
            "Size of sequence ${seq.size} does not equal size of weights ${weights.size}"
        )
    }

    if (weights.isEmpty()) {
        return 0.0
    }

    var weightedVal = 0.0

    weights.forEachIndexed { index, weight -> weightedVal += (weight * seq[index]) }

    return weightedVal / weights.sum()
}

fun weightedMean(seq: IntArray, weights: DoubleArray): Double =
    weightedMean(seq.map { it.toDouble() }.toDoubleArray(), weights)

fun weightedMean(seq: IntArray, weights: IntArray): Double =
    weightedMean(
        seq.map { it.toDouble() }.toDoubleArray(),
        weights.map { it.toDouble() }.toDoubleArray()
    )

fun weightedMean(seq: DoubleArray, weights: IntArray): Double =
    weightedMean(seq, weights.map { it.toDouble() }.toDoubleArray())
