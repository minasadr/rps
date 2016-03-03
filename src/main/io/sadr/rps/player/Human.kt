package io.sadr.rps.player

import io.sadr.rps.gesture.Gesture


class Human(override val name: String) : Player {
    override fun guess(gestures: List<Gesture>): Gesture {

        val peek = hashMapOf<String, Gesture>()

        for (n in gestures) {
            peek[n.code.toString()] = n
        }

        println("Please peak one of the followings:")
        for (n in gestures) {
            println(" - [${n.code} for ${n.name}]")
        }
        print("Enter your Choice: ")

        var choice = readLine()
        while (choice !in peek.keys) {
            print("Wrong input, enter your choice again: ")
            choice = readLine()
        }

        return peek[choice]!!
    }
}
