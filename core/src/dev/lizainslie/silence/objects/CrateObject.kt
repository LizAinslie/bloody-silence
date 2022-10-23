package dev.lizainslie.silence.objects

import com.badlogic.gdx.graphics.g3d.Model
import com.badlogic.gdx.graphics.g3d.ModelBatch
import dev.lizainslie.silence.asset.model.Modelable
import dev.lizainslie.silence.objects.player.Player
import dev.lizainslie.silence.objects.prop.Prop
import dev.lizainslie.silence.objects.prop.PropDescriptors

class CrateObject : Prop, Modelable {
    override val descriptor = PropDescriptors.CRATE

    override fun onInteract(player: Player) {
        // todo: crate logic
    }

    override fun getModel(modelBatch: ModelBatch): Model {
        TODO("Not yet implemented")
    }
}