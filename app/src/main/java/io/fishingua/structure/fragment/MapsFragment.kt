package io.fishingua.structure.fragment

import android.content.Intent
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.*

import com.google.android.gms.maps.model.LatLng
import io.fishingua.R
import io.fishingua.structure.activity.AreaDetailActivity
import io.fishingua.content.area.Area
import io.fishingua.extensions.getMarkerByArea

class MapsFragment : Fragment() {
    private lateinit var googleMap: GoogleMap
    private val areas = mutableMapOf<String, Area>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync { googleMap ->
            this.googleMap = googleMap.apply {
                moveCamera(CameraUpdateFactory.newLatLng(LatLng(50.45466, 30.5238)))
                setMinZoomPreference(5.5f)
            }
            storeMarkers(*Area.getAreas())
            googleMap.setOnInfoWindowClickListener { marker ->
                for ((tag, area) in areas) {
                    if (marker.tag == tag) {
                        startActivity(Intent(context, AreaDetailActivity::class.java).apply {
                            putExtra(AreaDetailActivity.Extra.AREA_NAME, area.name)
                        })
                        break
                    }
                }
            }
        }
    }

    private fun storeMarkers(vararg areas: Area) {
        for (area in areas) {
            val tag = area.name
            googleMap.getMarkerByArea(area, tag)
            this.areas[tag] = area
        }
    }
}