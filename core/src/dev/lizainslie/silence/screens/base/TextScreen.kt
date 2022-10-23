package dev.lizainslie.silence.screens.base

import com.badlogic.gdx.Input
import com.badlogic.gdx.Screen
import dev.lizainslie.silence.BloodySilenceGame
import dev.lizainslie.silence.screens.util.KeyPressListener

class TextScreen(
    game: BloodySilenceGame,
    private val lines: List<String>,
    private val nextScreen: (BloodySilenceGame) -> Screen
) : MenuScreen(game) {

    private val spaceListener = KeyPressListener(Input.Keys.SPACE) {
        game.screen = nextScreen(game)
        dispose()
    }

    override fun show() {
        game.multiplexer.addProcessor(spaceListener)
    }

    override fun render(delta: Float) {
        super.render(delta)

        game.batch.begin()

        var lineY = 100f

        lines.forEach { line ->
            game.font.draw(game.batch, line, 100f, lineY)
            lineY += 50f
        }

        game.batch.end()
    }
    override fun resize(width: Int, height: Int) {}
    override fun pause() {}
    override fun resume() {}
    override fun hide() {}

    override fun dispose() {
        game.multiplexer.removeProcessor(spaceListener)
    }
}