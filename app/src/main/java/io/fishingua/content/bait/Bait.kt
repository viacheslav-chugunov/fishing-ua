package io.fishingua.content.bait

import io.fishingua.structure.activity.RESOURCES

open class Bait(nameResId: Int, drawableResId: Int) {
    val name = RESOURCES.getString(nameResId)
    val drawableId = drawableResId

    override fun toString(): String = name
}