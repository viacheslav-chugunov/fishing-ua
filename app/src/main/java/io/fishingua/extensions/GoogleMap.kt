package io.fishingua.extensions

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import io.fishingua.content.area.Area

fun GoogleMap.getMarkerByArea(area: Area) : Marker {
    val areaPos = LatLng(area.mapPosition.x, area.mapPosition.y)
    return addMarker(MarkerOptions().position(areaPos).title(area.name))
}

fun GoogleMap.getMarkerByArea(area: Area, tag: String) : Marker {
    return getMarkerByArea(area).apply { this.tag = tag }
}