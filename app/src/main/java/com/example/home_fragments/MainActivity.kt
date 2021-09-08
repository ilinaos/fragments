package com.example.home_fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), Fragment1ClickListener {
    private var screen=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.main_container, Fragment1.newInstance(1))
            .commit()

    }

    override fun onClick() {
        screen++
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.main_container, Fragment1.newInstance(screen))
            .commit()
    }
}