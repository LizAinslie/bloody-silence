package dev.lizainslie.silence

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
object DesktopLauncher {
    @JvmStatic
    fun main(arg: Array<String>) {
        val config = Lwjgl3ApplicationConfiguration()
        config.setForegroundFPS(60)
        config.useVsync(true);
        config.setTitle("Bloody Silence")
        Lwjgl3Application(BloodySilenceGame(), config)
    }
}