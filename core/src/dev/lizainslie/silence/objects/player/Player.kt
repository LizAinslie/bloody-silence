package dev.lizainslie.silence.objects.player

import com.badlogic.gdx.graphics.g3d.Model
import com.badlogic.gdx.graphics.g3d.ModelBatch
import dev.lizainslie.silence.objects.Modelable

class Player(
    val name: String,
    val health: Int,
    val armor: Int
) : Modelable {
    override fun getModel(modelBatch: ModelBatch): Model {
        TODO("Not yet implemented")
    }
}