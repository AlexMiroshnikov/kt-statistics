package me.ilex.statistics

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class PercentileKtTest {
    @Test
    fun `it fails - because not implemented`() {
        assertEquals(0.0, percentile(arrayOf(1, 2, 3)))
    }
}
