package dev.lizainslie.silence.objects.prop

import dev.lizainslie.silence.objects.player.Player

interface Prop {
    val descriptor: String

    fun onInteract(player: Player)
}