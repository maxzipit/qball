package com.micromax.qbal.states

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.micromax.qbal.QBall

/**
 * Created by maks on 11/07/16.
 */
class MenuState(gsm: GameStateManager) : State(gsm) {

    private var bg: Texture = Texture("bg.png")
    private var playBtn: Texture = Texture("PNG/blue_button01.png")
    private lateinit var font: BitmapFont

    init {
        val generator = FreeTypeFontGenerator(Gdx.files.internal("Font/kenvector_future.ttf"))
        val parameter = FreeTypeFontGenerator.FreeTypeFontParameter()
        parameter.size = 16
        font = generator.generateFont(parameter) // font size 12 pixels
        generator.dispose()

        camera.setToOrtho(false, QBall().WIDTH, QBall().HEIGH)
        camera.position.x = camera.viewportWidth / 2
        camera.update()
    }


    override fun update(delta: Float) {
        handleInput()
    }

    override fun render(sb: SpriteBatch) {
        sb.projectionMatrix = camera.combined
        sb.begin()
        sb.draw(bg, 0f, 0f, QBall().WIDTH, QBall().HEIGH)
        sb.draw(playBtn, (QBall().WIDTH / 2 - playBtn.width / 2), (QBall().HEIGH / 2 - playBtn.height / 2))
        font.draw(sb, "Play", (QBall().WIDTH / 2), (QBall().HEIGH / 2))
        sb.end()
    }

    override fun dispose() {
        bg.dispose()
        playBtn.dispose()
    }

    override fun handleInput() {
        if(Gdx.input.justTouched()) {
            gsm.set(PlayState(gsm))
        }
    }
}