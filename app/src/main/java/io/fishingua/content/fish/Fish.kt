package io.fishingua.content.fish

import io.fishingua.structure.activity.RESOURCES
import io.fishingua.content.bait.Bait
import java.lang.IllegalArgumentException

private val FISHES = mutableSetOf<Fish>()

open class Fish(nameResId: Int, drawableResId: Int, vararg baits: Bait) {
    val baits = baits.toSet()
    val name = RESOURCES.getString(nameResId)
    val drawableId = drawableResId

    init { initFish() }

    private fun initFish() = FISHES.add(this)

    override fun toString(): String = name

    companion object {
        fun getFishes() = FISHES.toTypedArray()

        fun getFish(name: String) : Fish {
            for (fish in getFishes()) {
                if (name == fish.name) return fish
            }
            throw IllegalArgumentException("Unknown fish's name")
        }
    }
}