package com.micromax.qbal.states

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import java.util.*

/**
 * Created by maks on 11/07/16.
 */
class GameStateManager {

    private val stack: Stack<State> = Stack<State>()

    fun push(state: State){ stack.push(state)}

    fun pop() { stack.pop().dispose()}

    fun set(state: State) {
        stack.pop().dispose()
        stack.push(state)
    }

    fun update(delta: Float) {
        stack.peek().update(delta)
    }

    fun render(sb: SpriteBatch) {
        stack.peek().render(sb)
    }
}