package io.sadr.rps.player

import io.sadr.rps.gesture.PAPER
import io.sadr.rps.gesture.ROCK
import io.sadr.rps.gesture.SCISSORS
import org.junit.Test

import org.junit.Assert.*


class ComputerTest {

    @Test
    fun testGuess() {
        val gestures = listOf(ROCK, PAPER, SCISSORS)
        val player = Computer("Mina")
        val guess = player.guess(gestures)
        assertTrue(guess in gestures)
    }
}