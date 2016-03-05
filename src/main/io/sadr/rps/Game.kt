package io.sadr.rps

import io.sadr.rps.gesture.Gesture
import io.sadr.rps.player.Player
import java.util.*


class Game(val matrix: Map<Gesture, Gesture>, val firstPlayer: Player, val secondPlayer: Player) {

    fun play(): Result {
        val first = firstPlayer.guess(ArrayList(matrix.keys))
        val second = secondPlayer.guess(ArrayList(matrix.keys))

        val winner = when {
            matrix[first] == second -> firstPlayer
            matrix[second] == first -> secondPlayer
            else -> null
        }
        return Result(firstPlayer, secondPlayer, first, second, winner)
    }

}

