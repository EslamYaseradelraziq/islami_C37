package com.example.islamic37fri

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.islamic37fri.Adapter.SuraContentAdapter

class ItemSuraDetails : AppCompatActivity() {

    lateinit var suracontentRecyclerView: RecyclerView
    lateinit var adapter: SuraContentAdapter
    lateinit var icon_back: ImageView
    var suraposition: Int? = null
    var suraName: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_sura_details)
        suracontentRecyclerView = findViewById(R.id.suraContent_recycleview)
        adapter = SuraContentAdapter(null)
        suraName = intent.getStringExtra(Constants.ExtraSuraNameKey)
        suraposition = intent.getIntExtra(Constants.Sura_Position, 0)
        icon_back = findViewById(R.id.arrow_back)
        icon_back.setOnClickListener {
            finish()
            suracontentRecyclerView.adapter = adapter
            readFileText()

        }

    }

    fun readFileText() {

        val fileName = "${suraposition?.plus(1)}.txt"
        val fileContent: String = assets
            .open(fileName)
            .bufferedReader()
            .use { it.readText() }
        val suraContent = fileContent.split('\n')
        adapter.updateData(suraContent)
    }
}