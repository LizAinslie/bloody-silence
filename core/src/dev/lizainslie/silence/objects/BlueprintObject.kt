package dev.lizainslie.silence.objects

import dev.lizainslie.silence.player.Player
import dev.lizainslie.silence.prop.Prop
import dev.lizainslie.silence.prop.PropDescriptors

class BlueprintObject : Prop {
    override val descriptor = PropDescriptors.BLUEPRINT

    override fun onInteract(player: Player) {
        // todo: unlock blueprint piece to random rare weapon
    }
}