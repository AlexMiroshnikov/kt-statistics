package me.ilex.statistics.util

import java.math.BigInteger
import me.ilex.statistics.exceptions.InvalidArgumentException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class FactorialKtTest {

    @Test
    fun `it throws an exception - if arg is less than 0`() {
        assertThrows<InvalidArgumentException> { factorial(-1) }
    }

    @Test
    fun `it calculates expected values`() {
        listOf<Pair<Int, BigInteger>>(
            Pair(0, BigInteger.valueOf(1)),
            Pair(1, BigInteger.valueOf(1)),
            Pair(2, BigInteger.valueOf(2)),
            Pair(3, BigInteger.valueOf(6))
        ).forEach { assertEquals(it.second, factorial(it.first)) }
    }
}
