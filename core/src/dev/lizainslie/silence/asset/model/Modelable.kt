package dev.lizainslie.silence.asset.model

import com.badlogic.gdx.graphics.g3d.Model
import com.badlogic.gdx.graphics.g3d.ModelBatch

interface Modelable {
    fun getModel(modelBatch: ModelBatch): Model
}