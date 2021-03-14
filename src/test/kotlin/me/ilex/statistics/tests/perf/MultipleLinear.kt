package me.ilex.statistics.tests.perf

import java.util.Scanner
import me.ilex.statistics.regressions.MultipleLinear
import me.ilex.statistics.tests.PerfTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MultipleLinear : PerfTest() {
    @Test
    fun `perf test 1`() {
        assert(1)
    }

    @Test
    fun `perf test 2`() {
        assert(2)
    }

    private fun assert(resourceNum: Int) {
        val scan =
            Scanner(
                this::class.java
                    .getResource("/MultipleLinearRegression/$resourceNum/in.$resourceNum.txt")
                    .readText()
            )
        val input = Input(scan)

        val r = MultipleLinear(input.xs.toList(), input.y)
        val coefs = r.coefs().toSingleLine().split(" ").map { it.toDouble() }

        val outputScan =
            Scanner(
                this::class.java
                    .getResource("/MultipleLinearRegression/$resourceNum/out.$resourceNum.txt")
                    .readText()
            )

        input.lines
            .forEach {
                var result = coefs[0]

                it.forEachIndexed { index, d -> result += d * coefs[index + 1] }

                val expected = outputScan.nextLine().trim().toDouble()
                assertEquals(expected, result, 0.01)
            }
    }

    private class Input(scan: Scanner) {
        val inputParams = scan.nextLine().trim().split(" ").map { it.toInt() }.toTypedArray()
        private val m = inputParams[0]
        private val n = inputParams[1]
        val xs = Array(m) { DoubleArray(n) }
        val y = DoubleArray(n)

        var lines = mutableListOf<List<Double>>()

        init {
            for (i in 0 until n) {
                val line = scan.nextLine().trim().split(" ").map { it.toDouble() }

                for (j in 0 until m) {
                    xs[j][i] = line[j]
                }

                y[i] = line[m]
            }

            val q = scan.nextLine().trim().toInt()

            for (i in 0 until q) {
                lines.add(scan.nextLine().trim().split(" ").map { it.toDouble() })
            }
        }
    }
}
