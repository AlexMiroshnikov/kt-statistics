package me.ilex.statistics

import java.math.BigInteger

fun rank(seq: Array<Double>): Array<BigInteger> {
    val sortedSeq = seq.sorted().toTypedArray()
    var rank = 1.toBigInteger()
    var min = sortedSeq.first()
    val ranks = mutableMapOf(min to rank)

    sortedSeq.forEach {
        if (it != min) {
            rank++
            min = it
        }

        ranks[it] = rank
    }

    return seq.map { ranks[it]!! }.toTypedArray()
}

fun rank(seq: Array<Int>): Array<BigInteger> = rank(seq.map { it.toDouble() }.toTypedArray())
