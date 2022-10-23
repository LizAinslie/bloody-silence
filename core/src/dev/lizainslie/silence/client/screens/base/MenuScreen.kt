package dev.lizainslie.silence.client.screens.base

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.utils.ScreenUtils
import dev.lizainslie.silence.BloodySilenceGame

abstract class MenuScreen(protected val game: BloodySilenceGame) : Screen {
    private val camera = OrthographicCamera()

    init {
        camera.setToOrtho(
            false,
            Gdx.graphics.width.toFloat(),
            Gdx.graphics.height.toFloat()
        )
    }

    override fun render(delta: Float) {
        ScreenUtils.clear(Color.BLACK)

        camera.update()
        game.batch.projectionMatrix = camera.combined
    }
}