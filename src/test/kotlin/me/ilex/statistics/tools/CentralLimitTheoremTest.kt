package me.ilex.statistics.tools

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.math.pow

internal class CentralLimitTheoremTest {
    @Test
    fun `it works`() {
        val t = CentralLimitTheorem(205.0, 15.0.pow(2.0))
        val result = t.predict(49.0, 49.0)
        println(result)
    }
}
