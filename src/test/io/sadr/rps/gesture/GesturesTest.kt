package io.sadr.rps.gesture

import org.junit.Test

import org.junit.Assert.*

class GesturesTest {

    @Test
    fun testMatrix() {
        val m = matrix()
        assertEquals(3, m.size)
        assertEquals(SCISSORS, m[ROCK])
        assertEquals(PAPER, m[SCISSORS])
        assertEquals(ROCK, m[PAPER])
    }
}