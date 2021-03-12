package me.ilex.statistics.util

import java.math.BigInteger

fun factorial(num: Int): BigInteger {
    var result = BigInteger.ONE

    if (num >= 2) {
        for (i in 2..num) {
            result *= i.toBigInteger()
        }
    }

    return result
}
