package com.example.exampleapp.ui.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.exampleapp.R

class ViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.act_fragment)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.postViewFragment, PostFragment.newInstance())
                .commit()
        }
    }
}