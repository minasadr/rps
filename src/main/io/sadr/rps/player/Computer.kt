package io.sadr.rps.player

import io.sadr.rps.gesture.Gesture
import java.util.*


class Computer(override val name: String) : Player {
    val random = Random()


    override fun guess(gestures: List<Gesture>): Gesture {
        val choice = random.nextInt(gestures.size)  // ?
        return gestures[choice]

    }


    override fun toString(): String = "Computer[$name]"
}

