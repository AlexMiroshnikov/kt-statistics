package me.ilex.statistics.util

import java.math.BigInteger
import me.ilex.statistics.exceptions.InvalidArgumentException

fun factorial(num: Int): BigInteger {
    if (num < 0) {
        throw InvalidArgumentException("Only positive number can be passed, $num was given")
    }

    var result = BigInteger.ONE

    if (num >= 2) {
        (2..num).forEach { i -> result *= i.toBigInteger() }
    }

    return result
}
