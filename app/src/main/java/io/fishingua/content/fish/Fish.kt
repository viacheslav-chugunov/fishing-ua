package io.fishingua.content.fish

import io.fishingua.structure.activity.RESOURCES
import io.fishingua.content.bait.Bait
import java.lang.IllegalArgumentException

open class Fish(nameResId: Int, drawableResId: Int, vararg baits: Bait) {
    val baits = baits.toSet()
    val name = RESOURCES.getString(nameResId)
    val drawableId = drawableResId

    override fun toString(): String = name

    companion object {
        fun getFishes() = arrayOf(Pike, Grayling, Podust, Crucian, Bream, Roach, Zander, Carp,
            Catfish, Asp, Tench, Perch, SilverCarp, Amur, Ruff)

        fun getFish(name: String) : Fish {
            for (fish in getFishes()) {
                if (name == fish.name) return fish
            }
            throw IllegalArgumentException("Unknown fish's name")
        }
    }
}