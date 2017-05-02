package com.micromax.qbal.states

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputProcessor
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.GlyphLayout
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.micromax.qbal.Phrases
import com.micromax.qbal.QBall

/**
 * Created by maks on 13/07/16.
 */
class PlayState(gsm: GameStateManager) : State(gsm), InputProcessor {

    private lateinit var font: BitmapFont
    private var layout: GlyphLayout = GlyphLayout()

    private val phrases: Phrases = Phrases()

    private lateinit var selectedPhrase: String;

    init {
        val generator = FreeTypeFontGenerator(Gdx.files.internal("Font/kenvector_future.ttf"))
        val parameter = FreeTypeFontGenerator.FreeTypeFontParameter()
        parameter.size = 16
        font = generator.generateFont(parameter) // font size 12 pixels
        generator.dispose()

        camera.setToOrtho(false, QBall().WIDTH / 2f, QBall().HEIGH / 2f)

        camera.direction.set(0.001f, 0f, -0.1f)

        selectedPhrase = phrases[(Math.random() * phrases.size).toInt()]

        Gdx.input.inputProcessor = this
    }

    override fun update(delta: Float) {
        handleInput()

        camera.update()

        layout.setText(font, selectedPhrase)
    }

    override fun render(sb: SpriteBatch) {
        Gdx.gl.glClearColor(100f / 255f, 100f / 255f, 250f / 255f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        var fontX = (QBall().WIDTH - layout.width) / 2
        var fontY = (QBall().HEIGH + layout.height) / 2

        sb.begin()
        font.draw(sb, layout, fontX, fontY )
        sb.end()
    }


    override fun dispose() {
        font.dispose()
    }

    public override fun handleInput() {
        if(Gdx.input.justTouched()) {
            selectedPhrase = phrases[(Math.random() * phrases.size).toInt()]
        }
    }

    override fun touchUp(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean = false

    override fun mouseMoved(screenX: Int, screenY: Int): Boolean = false

    override fun keyTyped(character: Char): Boolean = false

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean = false

    override fun scrolled(amount: Int): Boolean = false

    override fun keyUp(keycode: Int): Boolean = false

    override fun touchDragged(screenX: Int, screenY: Int, pointer: Int): Boolean = false

    override fun keyDown(keycode: Int): Boolean = false
}