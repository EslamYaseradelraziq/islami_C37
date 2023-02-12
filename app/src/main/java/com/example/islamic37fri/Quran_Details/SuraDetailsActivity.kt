package com.example.islamic37fri.Quran_Details

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.islamic37fri.Adapter.SuraContentAdapter
import com.example.islamic37fri.Constants
import com.example.islamic37fri.R

class SuraDetailsActivity : AppCompatActivity() {
    var position: Int? = null
    var content: String? = null
    lateinit var suraContentRecyclerView: RecyclerView
    lateinit var adapter: SuraContentAdapter
    lateinit var icon_back: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)
        suraContentRecyclerView = findViewById(R.id.suraContent_recycleview)
        adapter = SuraContentAdapter(null)
        content = intent.getStringExtra(Constants.ExtraSuraNameKey)
        position = intent.getIntExtra(Constants.Sura_Position, -1)
        suraContentRecyclerView.adapter = adapter
        readFileText()
        icon_back = findViewById(R.id.arrow_back)
        icon_back.setOnClickListener {
            finish()
        }


    }

    fun readFileText() {
        val filename = "${position?.plus(1)}.txt"
        val fileContent: String = assets.open(filename).bufferedReader().use { it.readText() }

        val suraContent = fileContent.split('\n')
        adapter.updateData(suraContent)
    }
}