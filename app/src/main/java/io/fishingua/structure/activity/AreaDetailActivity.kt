package io.fishingua.structure.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.fishingua.structure.fragment.DetailFragment
import io.fishingua.R
import io.fishingua.content.area.Area
import kotlinx.android.synthetic.main.toolbar.*

class AreaDetailActivity : AppCompatActivity() {
    object Extra { const val AREA_NAME = "AREA_NAME" }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_area_detail)
        val area = Area.getArea(intent.extras?.getString(Extra.AREA_NAME)!!)
        setSupportActionBar(toolbar.apply { title = area.name })
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (supportFragmentManager.findFragmentById(R.id.area_detail_fragment) as DetailFragment).run {
            putArgument(DetailFragment.Arguments.DRAWABLE_ID, area.drawableId)
            putArgument(DetailFragment.Arguments.FISH_LIST, area.fishes.toList())
            putArgument(DetailFragment.Arguments.DESCRIPTION_TEXT, getString(R.string.what_you_can_head))
        }
    }
}