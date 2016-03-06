package io.sadr.rps

import io.sadr.rps.gesture.matrix
import io.sadr.rps.player.Computer
import io.sadr.rps.player.Human
import io.sadr.rps.player.Player


class Console {
    private val YES = "y"
    private val NO = "n"
    private val COMPUTER = "c"
    private val HUMAN = "h"
    private val PLAYER_A = "player A"
    private val PLAYER_B = "player B"

    fun run() {
        println("Welcome to the Game")
        do {
            val type = chooseGameType()
            val game = Game(matrix(), chooseFirstPlayer(type), chooseSecondPlayer())
            do {
                val result = game.play()
                showResult(result)
            } while (YES == repeat())
        } while (YES == newGame())
        println("See you again")
    }

    private fun showResult(result: Result) {
        println(result.toString()) //Println(result)
    }

    private fun chooseSecondPlayer(): Player {
        return Computer(PLAYER_B)
    }

    private fun chooseFirstPlayer(gameType: String): Player {
        return if (gameType == COMPUTER) Computer(PLAYER_A) else Human(PLAYER_A)
    }

    private fun chooseGameType(): String {
        println("please choose your game type:")
        print("(h) for Human vs Computer or (c) for Computer vs Computer: ")
        var choose = readLine()
        while (choose != HUMAN && choose != COMPUTER) {
            print("Wrong input, enter your choice again: ")
            choose = readLine()
        }
        return choose
    }

    private fun newGame(): String {
        print("Would you like to play new game? enter (y) for yes or (n) for no: ")
        var choose = readLine()
        while (choose != NO && choose != YES) {
            print("Wrong input, enter your choice again: ")
            choose = readLine()
        }
        return choose
    }

    private fun repeat(): String {
        print("Would you like to continue? enter (y) for yes or (n) for no: ")
        var choose = readLine()
        while (choose != YES && choose != NO) {
            print("Wrong input, enter your choice again: ")
            choose = readLine()
        }
        return choose
    }
}