package me.ilex.statistics.util

import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.sqrt

class Erf {
    companion object {
        private var denominators = mutableMapOf<Int, Double>()

        private fun tailor(x: Double, approx: Int): Double {
            var result = 0.0
            var member: Double

            for (n in 0..approx) {
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

        fun calc(x: Double, approx: Int = 17): Double {
            return 2 / sqrt(PI) * tailor(x, approx)
        }
    }
}
