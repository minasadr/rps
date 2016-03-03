package io.sadr.rps.player

import io.sadr.rps.gesture.Gesture

interface Player {
    val name: String

    fun guess(gestures: List<Gesture>): Gesture
}



