package me.ilex.statistics.regressions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MultipleLinearTest {

    @Test
    fun `it`() {
        val ml =
            MultipleLinear(
                intArrayOf(5, 6, 7, 8, 9).map { it.toDouble() }.toDoubleArray(),
                intArrayOf(7, 6, 4, 5, 6).map { it.toDouble() }.toDoubleArray(),
                intArrayOf(10, 20, 60, 40, 50).map { it.toDouble() }.toDoubleArray()
            )
        assertEquals(
            "51.953488372093005 6.651162790697665 -11.162790697674431",
            ml.coefs().toSingleLine()
        )
    }
}
