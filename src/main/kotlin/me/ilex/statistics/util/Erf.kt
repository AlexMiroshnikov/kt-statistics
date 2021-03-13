package me.ilex.statistics.util

import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.sqrt
import me.ilex.statistics.exceptions.InvalidArgumentException

class Erf {
    companion object {
        private const val MIN_APPROX = 17

        private var denominators = mutableMapOf<Int, Double>()

        private fun tailor(x: Double, approx: Int): Double {
            var result = 0.0
            var member: Double

            (0..approx)
                .forEach { n ->
                    member = x.pow(2 * n + 1)

                    if (n > 0) {
                        member /= denominator(n)

                        if (n % 2 == 1) {
                            member = -member
                        }
                    }

                    result += member
                }

            return result
        }

        private fun denominator(n: Int): Double {
            if (!denominators.contains(n)) {
                denominators[n] = factorial(n).toDouble() * (2 * n + 1).toDouble()
            }

            return denominators[n]!!
        }

        fun calc(x: Double, approx: Int = MIN_APPROX): Double {
            if (approx < MIN_APPROX) {
                throw InvalidArgumentException(
                    "approx $approx was given, but it must be not less than $MIN_APPROX, " +
                        "otherwise calculation precision is too low"
                )
            }

            return 2 / sqrt(PI) * tailor(x, approx)
        }
    }
}
