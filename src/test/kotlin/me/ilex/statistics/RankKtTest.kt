package me.ilex.statistics

import java.math.BigInteger
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

internal class RankKtTest {

    @Test
    fun `returns expected ranks`() {
        val seq = arrayOf(1, 2, 5, 1, 2)
        assertArrayEquals(
            arrayOf(
                BigInteger.valueOf(1),
                BigInteger.valueOf(2),
                BigInteger.valueOf(3),
                BigInteger.valueOf(1),
                BigInteger.valueOf(2)
            ),
            rank(seq)
        )
    }
}
