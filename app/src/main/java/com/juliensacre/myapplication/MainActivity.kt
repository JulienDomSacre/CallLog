package com.juliensacre.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.juliensacre.myapplication.ui.hub.HubFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, HubFragment.newInstance())
                .commitNow()
        }
    }

}
