package io.sadr.rps

import io.sadr.rps.gesture.*
import io.sadr.rps.player.Computer
import javafx.application.Application
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.scene.control.*
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.*
import javafx.stage.Stage
import java.util.*

class FxUi : Application() {

    val firstButtons = HashMap<Gesture, ToggleButton>()
    val secondButtons = HashMap<Gesture, ToggleButton>()

    fun run() {
        launch()
    }

    override fun start(stage: Stage) {
        stage.title = "RPS - a simple game"
        val root = BorderPane()

        firstButtons[ROCK] = ToggleButton(null, ImageView(Image("rock.png", 60.0, 60.0, true, true)))
        secondButtons[ROCK] = ToggleButton(null, ImageView(Image("rock.png", 60.0, 60.0, true, true)))
        firstButtons[PAPER] = ToggleButton(null, ImageView(Image("paper.png", 60.0, 60.0, true, true)))
        secondButtons[PAPER] = ToggleButton(null, ImageView(Image("paper.png", 60.0, 60.0, true, true)))
        firstButtons[SCISSORS] = ToggleButton(null, ImageView(Image("scissors.png", 60.0, 60.0, true, true)))
        secondButtons[SCISSORS] = ToggleButton(null, ImageView(Image("scissors.png", 60.0, 60.0, true, true)))

        root.left = makeBoard(firstButtons)
        root.right = makeBoard(secondButtons)
        root.top = makeToolBar()

        val status = Label()
        root.center = makePlay(status)
        val down = StackPane(status)
        root.bottom = down
        stage.scene = Scene(root, 700.0, 400.0)
        stage.show()
    }

    private fun makePlay(status: Label): Pane {
        val pane = StackPane()
        val play = Button("Play")
        play.onAction = EventHandler {
            val game = Game(matrix(), Computer("left"), Computer("right"))
            val result = game.play()
            firstButtons[result.firstGesture]?.isSelected = true
            secondButtons[result.secondGesture]?.isSelected = true
            val text = when(result.winner) {
                result.firstPlayer -> "winner is left player"
                result.secondPlayer -> "winner is right player"
                else -> "the game is equal"
            }
            status.text = text
        }
        pane.children.add(play)
        return pane
    }

    fun makeBoard(buttons: Map<Gesture, ToggleButton>): Pane {
        val group = ToggleGroup()
        val board = FlowPane()
        addGesture(board, group, buttons)
        return board
    }

    fun addGesture(pane: Pane, group: ToggleGroup, buttons: Map<Gesture, ToggleButton>) {
        buttons.values.forEach {
            it.toggleGroup = group
            pane.children.add(it)
        }
    }

    fun makeToolBar(): ToolBar {
        val cvsc = ToggleButton("Computer Vs. Computer")
        val cvsh = ToggleButton("Computer Vs. Human")
        val group = ToggleGroup()
        cvsc.toggleGroup = group
        cvsh.toggleGroup = group
        return ToolBar(cvsc, cvsh)
    }
}
