package dev.lizainslie.silence.client.screens

import com.badlogic.gdx.Input
import dev.lizainslie.silence.BloodySilenceGame
import dev.lizainslie.silence.client.screens.base.MenuScreen
import dev.lizainslie.silence.client.screens.base.TextScreen
import dev.lizainslie.silence.client.util.KeyPressListener

class MainMenuScreen(game: BloodySilenceGame) : MenuScreen(game) {
    private val spaceListener = KeyPressListener(Input.Keys.SPACE) {
        game.screen = TextScreen(
            game,
            listOf(
                "This is a shooter unlike any you have ever played. There is no sound whatsoever,",
                "so you will need to use your eyesight to find indicators of enemy presence.",
                "The silence will deafen you. The silence will kill you. Unless you kill the enemy first.",
                "",
                "Press SPACE if you're ready for a challenge."
            )
        ) { GameScreen(it) }
        dispose()
    }

    init {
        game.multiplexer.addProcessor(spaceListener)
    }

    override fun show() {}

    override fun render(delta: Float) {
        super.render(delta)

        game.batch.begin()
        game.font.draw(game.batch, "Welcome to Bloody Silence", 100f, 150f)
        game.font.draw(game.batch, "Press the space bar to begin", 100f, 100f)
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