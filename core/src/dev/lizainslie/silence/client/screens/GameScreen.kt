package dev.lizainslie.silence.client.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.PerspectiveCamera
import com.badlogic.gdx.graphics.VertexAttributes
import com.badlogic.gdx.graphics.g3d.*
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder
import dev.lizainslie.silence.BloodySilenceGame

class GameScreen(private val game: BloodySilenceGame) : Screen {
    private val camera = PerspectiveCamera(
        67f,
        Gdx.graphics.width.toFloat(),
        Gdx.graphics.height.toFloat()
    )

    private val environment = Environment()
    private val modelBatch = ModelBatch()
    private val model: Model
    private val modelInstance: ModelInstance

    init {
        camera.position.set(10f, 10f, 10f)
        camera.lookAt(0f, 0f, 0f)
        camera.near = 1f
        camera.far = 300f
        camera.update()

        environment.set(ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f))
        environment.add(DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f))

        val modelBuilder = ModelBuilder()
        model = modelBuilder.createBox(
            5f, 5f, 5f,
            Material(ColorAttribute.createDiffuse(Color.GREEN)),
            VertexAttributes.Usage.Position.toLong() or VertexAttributes.Usage.Normal.toLong()
        )
        modelInstance = ModelInstance(model)
    }

    override fun show() {}

    override fun render(delta: Float) {
        Gdx.gl.glViewport(0, 0, Gdx.graphics.width, Gdx.graphics.height)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT or GL20.GL_DEPTH_BUFFER_BIT)

        modelBatch.begin(camera)
        modelBatch.render(modelInstance, environment)
        modelBatch.end()
    }

    override fun resize(width: Int, height: Int) {}
    override fun pause() {}
    override fun resume() {}
    override fun hide() {}
    override fun dispose() {
        modelBatch.dispose()
        model.dispose()
    }
}