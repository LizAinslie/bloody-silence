package dev.lizainslie.silence.prop

import dev.lizainslie.silence.player.Player

interface Prop {
    val descriptor: String

    fun onInteract(player: Player)
}