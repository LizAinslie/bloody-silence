package dev.lizainslie.silence.objects

import dev.lizainslie.silence.player.Player
import dev.lizainslie.silence.prop.Prop
import dev.lizainslie.silence.prop.PropDescriptors

class CrateObject : Prop {
    override val descriptor = PropDescriptors.CRATE

    override fun onInteract(player: Player) {
        // todo: crate logic
    }
}