package dev.lizainslie.silence.client.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.PerspectiveCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g3d.*
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController
import dev.lizainslie.silence.BloodySilenceGame


class GameScreen(private val game: BloodySilenceGame) : Screen {
    private val camera = PerspectiveCamera(
        67f,
        Gdx.graphics.width.toFloat(),
        Gdx.graphics.height.toFloat()
    )

    private val environment = Environment()
    private val modelBatch = ModelBatch()
    private val modelInstances: MutableList<ModelInstance> = mutableListOf()
    private val cameraController = CameraInputController(camera)
    private val assetManager = AssetManager()
    private var loading: Boolean

    init {
        camera.position.set(10f, 10f, 10f)
        camera.lookAt(0f, 0f, 0f)
        camera.near = 1f
        camera.far = 300f
        camera.update()

        environment.set(ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f))
        environment.add(DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f))

        game.multiplexer.addProcessor(cameraController)

        assetManager.load("model/lootbox.g3db", Model::class.java)
        assetManager.load("model/lootbox_1_bottom.png", Texture::class.java)
        assetManager.load("model/lootbox_1_top.png", Texture::class.java)
        loading = true

    }

    override fun show() {}

    private fun assetsLoaded() {
        val model = assetManager.get("model/lootbox.g3db", Model::class.java)
        val inst = ModelInstance(model)
        val texture0 = assetManager.get("model/lootbox_1_bottom.png", Texture::class.java)
        val texture1 = assetManager.get("model/lootbox_1_top.png", Texture::class.java)

        texture0.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest)
        texture1.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest)

        inst.getMaterial("m_0").set(TextureAttribute.createDiffuse(texture0))
        inst.getMaterial("m_1").set(TextureAttribute.createDiffuse(texture1))

        modelInstances += inst
        loading = false
    }

    override fun render(delta: Float) {
        if (loading && assetManager.update()) assetsLoaded()
        cameraController.update()

        Gdx.gl.glViewport(0, 0, Gdx.graphics.width, Gdx.graphics.height)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT or GL20.GL_DEPTH_BUFFER_BIT)

        modelBatch.begin(camera)
        modelBatch.render(modelInstances, environment)
        modelBatch.end()
    }

    override fun resize(width: Int, height: Int) {}
    override fun pause() {}
    override fun resume() {}
    override fun hide() {}
    override fun dispose() {
        modelBatch.dispose()
        modelInstances.clear()
        assetManager.dispose()
    }
}