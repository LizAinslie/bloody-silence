package dev.lizainslie.silence.objects

import dev.lizainslie.silence.player.Player
import dev.lizainslie.silence.prop.Prop
import dev.lizainslie.silence.prop.PropDescriptors

class LootboxObject : Prop {
    override val descriptor = PropDescriptors.LOOTBOX

    override fun onInteract(player: Player) {
        // todo: inventory logic
    }
}