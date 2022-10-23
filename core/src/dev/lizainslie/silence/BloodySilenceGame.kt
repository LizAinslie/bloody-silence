package dev.lizainslie.silence

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputMultiplexer
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import dev.lizainslie.silence.client.screens.MainMenuScreen


class BloodySilenceGame : Game() {
    lateinit var batch: SpriteBatch
    lateinit var font: BitmapFont
    lateinit var multiplexer: InputMultiplexer

    override fun create() {
        batch = SpriteBatch()
        font = BitmapFont()

        multiplexer = InputMultiplexer()
        Gdx.input.inputProcessor = multiplexer
        screen = MainMenuScreen(this)
    }

    override fun dispose() {
    }
}