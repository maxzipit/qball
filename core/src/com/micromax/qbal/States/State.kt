package com.micromax.qbal.states

import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector3

/**
 * Created by maks on 11/06/16.
 */
abstract  class State(protected var gsm: GameStateManager) {

    protected var camera: OrthographicCamera = OrthographicCamera()
    protected var mouse: Vector3 = Vector3()

    protected abstract fun handleInput()
    abstract fun update(delta: Float)
    abstract fun render(sb: SpriteBatch)
    abstract fun dispose()
}