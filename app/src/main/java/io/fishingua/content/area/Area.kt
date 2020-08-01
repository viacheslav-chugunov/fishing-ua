package io.fishingua.content.area

import io.fishingua.structure.activity.RESOURCES
import io.fishingua.content.fish.Fish
import java.lang.IllegalArgumentException

open class Area(nameResId: Int, drawableResId: Int, val mapPosition: GoogleMapPosition, vararg fishes: Fish) {
    val fishes: Set<Fish> = fishes.toSet()
    val name = RESOURCES.getString(nameResId)
    val drawableId = drawableResId

    override fun toString(): String = name

    class GoogleMapPosition(val x: Double, val y: Double)

    companion object {
        fun getAreas() = arrayOf(Kozintsa, KievReservoir, AmateurPond, Ostapovka, Kutsevolovka,
            RadFlag, Korobchino)

        fun getArea(name: String) : Area {
            for (area in getAreas()) {
                if (name == area.name) return area
            }
            throw IllegalArgumentException("Unknown area's name")
        }
    }
}