package com.example.islamic37fri.main_fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.islamic37fri.Adapter.SuraNamesAdapter
import com.example.islamic37fri.CallBacks.onSuraClickListener
import com.example.islamic37fri.Constants
import com.example.islamic37fri.Data_Model.ArSuras
import com.example.islamic37fri.Quran_Details.SuraDetailsActivity
import com.example.islamic37fri.R

class QuranFragment : Fragment() {
    lateinit var quranRecycleView: RecyclerView
    lateinit var quranAdapter: SuraNamesAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quran_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        quranRecycleView = view.findViewById(R.id.recycle_view)
        quranAdapter = SuraNamesAdapter(ArSuras)
        quranRecycleView.adapter = quranAdapter
        quranAdapter.onSuraClickListener = object : onSuraClickListener {
            override fun onSuraClick(position: Int, suraName: String?) {
                var intent1 = Intent(requireActivity(), SuraDetailsActivity::class.java)
                intent1.putExtra(Constants.Sura_Position, position)
                intent1.putExtra(Constants.ExtraSuraNameKey, suraName)
                startActivity(intent1)
            }
        }


    }
}