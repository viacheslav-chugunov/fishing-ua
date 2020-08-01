package io.fishingua.structure.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.fishingua.R
import io.fishingua.content.fish.Fish
import io.fishingua.structure.fragment.DetailFragment
import kotlinx.android.synthetic.main.toolbar.*

class FishDetailActivity : AppCompatActivity() {
    object Extra { const val FISH_NAME = "FISH_NAME" }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fish_detail)
        val fish = Fish.getFish(intent.extras?.getString(Extra.FISH_NAME)!!)
        setSupportActionBar(toolbar.apply { title = fish.name })
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (supportFragmentManager.findFragmentById(R.id.fish_detail_fragment) as DetailFragment).run {
            putArgument(DetailFragment.Arguments.DRAWABLE_ID, fish.drawableId)
            putArgument(DetailFragment.Arguments.BAIT_LIST, fish.baits.toList())
            putArgument(DetailFragment.Arguments.DESCRIPTION_TEXT, getString(R.string.fish_bait))
        }
    }
}