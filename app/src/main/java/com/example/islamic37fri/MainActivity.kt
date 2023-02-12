package com.example.islamic37fri

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.islamic37fri.main_fragments.AhadethFragment
import com.example.islamic37fri.main_fragments.QuranFragment
import com.example.islamic37fri.main_fragments.RadioFragment
import com.example.islamic37fri.main_fragments.SebhaFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    lateinit var bottomNavigationItemView: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationItemView = findViewById(R.id.bottom_navigation_view)

        bottomNavigationItemView.setOnItemSelectedListener {
            if (it.itemId == R.id.quran) {
                pushFragment(QuranFragment())

            } else if (it.itemId == R.id.Tasbeh) {
                pushFragment(SebhaFragment())

            } else if (it.itemId == R.id.ahadeth) {
                pushFragment(AhadethFragment())
            } else if (it.itemId == R.id.radio) {
                pushFragment(RadioFragment())
            }

            return@setOnItemSelectedListener true
        }
        bottomNavigationItemView.selectedItemId = R.id.quran

    }

    fun pushFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container_fragment, fragment)
            .commit()
    }

}