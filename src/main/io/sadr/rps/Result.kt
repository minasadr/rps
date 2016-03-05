package io.sadr.rps

import io.sadr.rps.gesture.Gesture
import io.sadr.rps.player.Player


class Result(
        val firstPlayer: Player,
        val secondPlayer: Player,
        val firstGesture: Gesture,
        val secondGesture: Gesture,
        val winner: Player?) {

    override fun toString(): String {
        val result = if (winner != null) "winner is $winner" else "The game is equal"
        return "{$firstPlayer($firstGesture) vs. $secondPlayer($secondGesture) => $result}"
    }

}

