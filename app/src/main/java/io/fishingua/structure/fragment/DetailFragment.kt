package io.fishingua.structure.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.fishingua.R
import io.fishingua.content.bait.Bait
import io.fishingua.content.fish.Fish
import io.fishingua.interfaces.ArgumentsContainer
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment(), ArgumentsContainer {
    object Arguments {
        const val DRAWABLE_ID = "DRAWABLE_ID"
        const val FISH_LIST = "FISH_LIST"
        const val BAIT_LIST = "BAIT_LIST"
        const val DESCRIPTION_TEXT = "DESCRIPTION_TEXT"
    }

    private var drawableId: Int? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onStart() {
        super.onStart()
        drawableId?.let { detail_image.setImageResource(it) }
    }

    override fun <T> putArgument(name: String, value: T) {
        when (name) {
            Arguments.DRAWABLE_ID -> drawableId = value as Int
            Arguments.FISH_LIST -> (childFragmentManager.findFragmentById(R.id.card_list_fragment) as CardListFragment)
                .putArgument(CardListFragment.Arguments.FISH_LIST, value as List<Fish>)
            Arguments.BAIT_LIST -> (childFragmentManager.findFragmentById(R.id.card_list_fragment) as CardListFragment)
                .putArgument(CardListFragment.Arguments.BAIT_LIST, value as List<Bait>)
            Arguments.DESCRIPTION_TEXT -> detail_text.text = value as String
        }
    }
}