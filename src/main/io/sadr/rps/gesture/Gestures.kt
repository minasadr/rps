package io.sadr.rps.gesture

class Gesture(val code: Char, val name: String) {
    override fun toString(): String = "Gesture[$code, $name]"
}

val ROCK = Gesture('r', "Rock")

val PAPER = Gesture('p', "Paper")

val SCISSORS = Gesture('s', "Scissors")

private val CLASSIC_MATRIX = mapOf(ROCK to SCISSORS, PAPER to ROCK, SCISSORS to PAPER)

fun matrix(): Map<Gesture, Gesture> = CLASSIC_MATRIX   // why map og Gesture and Gesture?