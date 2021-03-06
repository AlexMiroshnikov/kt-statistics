package me.ilex.statistics

fun interquartileRange(seq: Array<Double>): Double =
    quartile(seq, Quartile.THIRD) - quartile(seq, Quartile.FIRST)

fun interquartileRange(seq: Array<Int>): Double =
    interquartileRange(seq.map { it.toDouble() }.toTypedArray())
