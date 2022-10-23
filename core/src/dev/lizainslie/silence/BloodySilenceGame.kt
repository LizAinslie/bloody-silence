package dev.lizainslie.silence

import com.badlogic.gdx.Game
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import dev.lizainslie.silence.screens.MainMenuScreen

class BloodySilenceGame : Game() {
    lateinit var batch: SpriteBatch
    lateinit var font: BitmapFont

    override fun create() {
        batch = SpriteBatch()
        font = BitmapFont()
        screen = MainMenuScreen(this)
    }

    override fun dispose() {
    }
}