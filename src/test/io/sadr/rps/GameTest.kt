package io.sadr.rps

import io.sadr.rps.gesture.*
import io.sadr.rps.player.Player
import org.junit.Test

import org.junit.Assert.*


class GameTest {

    @Test
    fun testPlayRockVsPaper() {
        val first = RockPlayer("M")
        val second = PaperPlayer("S")
        val game = Game(matrix(), first, second)
        val result = game.play()
        assertEquals(second, result.winner)
    }

    @Test
    fun testPlayScissorsVsPaper() {
        val first = ScissorsPlayer("M")
        val second = PaperPlayer("S")
        val game = Game(matrix(), first, second)
        val result = game.play()
        assertEquals(first, result.winner)
    }

    @Test
    fun testPlayRockVsScissors() {
        val first = RockPlayer("M")
        val second = ScissorsPlayer("S")
        val game = Game(matrix(), first, second)
        val result = game.play()
        assertEquals(first, result.winner)
    }

    @Test
    fun testPlayRockVsRock() {
        val first = RockPlayer("M")
        val game = Game(matrix(), first, first)
        val result = game.play()
        assertEquals(null, result.winner)
    }

    @Test
    fun testPlayScissorsVsScissors() {
        val first = ScissorsPlayer("M")
        val game = Game(matrix(), first, first)
        val result = game.play()
        assertEquals(null, result.winner)
    }

    @Test
    fun testPlayPaperVsPaper() {
        val second = PaperPlayer("S")
        val game = Game(matrix(), second, second)
        val result = game.play()
        assertEquals(null, result.winner)
    }

}

private class RockPlayer(override val name: String) : Player {
    override fun guess(gestures: List<Gesture>): Gesture = ROCK
}

private class ScissorsPlayer(override val name: String) : Player {
    override fun guess(gestures: List<Gesture>): Gesture = SCISSORS
}

private class PaperPlayer(override val name: String) : Player {
    override fun guess(gestures: List<Gesture>): Gesture = PAPER
}

