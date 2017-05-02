package com.micromax.qbal

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.micromax.qbal.states.GameStateManager
import com.micromax.qbal.states.MenuState

class QBall : ApplicationAdapter() {

    val WIDTH: Float = 480f
    val HEIGH: Float = 800f

    val TITLE: String = "QBall"

    private lateinit var gsm: GameStateManager
    private lateinit var batch: SpriteBatch


    override fun create() {
        gsm = GameStateManager()
        batch = SpriteBatch()
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        gsm.push(MenuState(gsm))
    }

    override fun render() {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        gsm.update(Gdx.graphics.deltaTime)
        gsm.render(batch)
    }
}