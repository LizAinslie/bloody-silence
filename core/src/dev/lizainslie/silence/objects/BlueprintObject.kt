package dev.lizainslie.silence.objects

import com.badlogic.gdx.graphics.g3d.Model
import com.badlogic.gdx.graphics.g3d.ModelBatch
import dev.lizainslie.silence.asset.model.Modelable
import dev.lizainslie.silence.objects.player.Player
import dev.lizainslie.silence.prop.Prop
import dev.lizainslie.silence.prop.PropDescriptors

class BlueprintObject : Prop, Modelable {
    override val descriptor = PropDescriptors.BLUEPRINT

    override fun onInteract(player: Player) {
        // todo: unlock blueprint piece to random rare weapon
    }

    override fun getModel(modelBatch: ModelBatch): Model {
        TODO("Not yet implemented")
    }
}