package io.fishingua.structure.activity

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.fishingua.R
import kotlinx.android.synthetic.main.toolbar.*

lateinit var RESOURCES: Resources

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        RESOURCES = resources
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar.apply { title = getString(R.string.app_name) })
    }
}