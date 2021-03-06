package me.ilex.statistics

import me.ilex.statistics.exceptions.InvalidArgumentException

fun weightedMean(seq: Array<Double>, weights: Array<Double>): Double {
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

fun weightedMean(seq: Array<Int>, weights: Array<Double>): Double =
    weightedMean(seq.map { it.toDouble() }.toTypedArray(), weights)

fun weightedMean(seq: Array<Int>, weights: Array<Int>): Double =
    weightedMean(
        seq.map { it.toDouble() }.toTypedArray(),
        weights.map { it.toDouble() }.toTypedArray()
    )

fun weightedMean(seq: Array<Double>, weights: Array<Int>): Double =
    weightedMean(seq, weights.map { it.toDouble() }.toTypedArray())
