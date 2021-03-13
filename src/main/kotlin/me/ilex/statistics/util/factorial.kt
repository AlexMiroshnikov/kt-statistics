package me.ilex.statistics.util

import java.math.BigInteger
import me.ilex.statistics.exceptions.InvalidArgumentException

fun factorial(num: Int): BigInteger {
    if (num < 0) {
        throw InvalidArgumentException("Only positive number can be passed, $num was given")
    }

    var result = BigInteger.ONE

    if (num >= 2) {
        for (i in 2..num) {
            result *= i.toBigInteger()
        }
    }

    return result
}
