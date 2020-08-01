package io.fishingua.structure.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.fishingua.adapter.BaitRecyclerViewAdapter
import io.fishingua.adapter.FishRecyclerViewAdapter
import io.fishingua.R
import io.fishingua.structure.activity.FishDetailActivity
import io.fishingua.content.bait.Bait
import io.fishingua.content.fish.Fish
import io.fishingua.interfaces.ArgumentsContainer

class CardListFragment : Fragment(), ArgumentsContainer {
    object Arguments {
        const val FISH_LIST = "FISH_LIST"
        const val BAIT_LIST = "BAIT_LIST"
    }

    private var listView: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_card_list, container, false)
        if (view is RecyclerView) {
            listView = view.apply { layoutManager = GridLayoutManager(context, 2) }
        }
        return view
    }

    override fun <T> putArgument(name: String, value: T) {
        when(name) {
            Arguments.FISH_LIST -> listView?.adapter =
                FishRecyclerViewAdapter(value as List<Fish>) { position ->
                    startActivity(Intent(context, FishDetailActivity::class.java).apply {
                        putExtra(FishDetailActivity.Extra.FISH_NAME, value[position].name)
                    })
                }
            Arguments.BAIT_LIST -> listView?.adapter =
                BaitRecyclerViewAdapter(value as List<Bait>)
        }
    }
}