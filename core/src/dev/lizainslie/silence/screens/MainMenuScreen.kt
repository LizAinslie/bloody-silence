package dev.lizainslie.silence.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.utils.ScreenUtils
import dev.lizainslie.silence.BloodySilenceGame

class MainMenuScreen(private val game: BloodySilenceGame) : Screen {
    private val camera = OrthographicCamera()

    init {
        camera.setToOrtho(
            false,
            Gdx.graphics.width.toFloat(),
            Gdx.graphics.height.toFloat()
        )
    }

    override fun show() {}

    override fun render(delta: Float) {
        ScreenUtils.clear(Color.BLACK)

        camera.update()
        game.batch.projectionMatrix = camera.combined

        game.batch.begin()
        game.font.draw(game.batch, "Welcome to Bloody Silence", 100f, 150f)
        game.font.draw(game.batch, "Press the space bar to begin", 100f, 100f)
        game.batch.end()

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            game.screen = GameScreen(game)
            dispose()
        }
    }

    override fun resize(width: Int, height: Int) {}
    override fun pause() {}
    override fun resume() {}
    override fun hide() {}
    override fun dispose() {}
}