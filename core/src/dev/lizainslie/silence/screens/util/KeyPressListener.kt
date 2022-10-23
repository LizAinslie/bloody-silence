package dev.lizainslie.silence.screens.util

import com.badlogic.gdx.InputAdapter

class KeyPressListener(private val key: Int, private val handle: () -> Unit) : InputAdapter() {
    override fun keyDown(keycode: Int): Boolean {
        if (keycode == key) {
            handle()
            return true
        }
        return super.keyDown(keycode)
    }
}