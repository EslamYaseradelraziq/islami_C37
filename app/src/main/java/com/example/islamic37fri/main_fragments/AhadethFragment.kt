package com.example.islamic37fri.main_fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.islamic37fri.Hadeth
import com.example.islamic37fri.HadethTitleRecycleAdapter
import com.example.islamic37fri.databinding.AhadethFragmentBinding

class AhadethFragment : Fragment() {
    lateinit var binding: AhadethFragmentBinding
    private val TAG = "AhadethFragment"
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AhadethFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    lateinit var adapter: HadethTitleRecycleAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        readhadethfile()
        adapter = HadethTitleRecycleAdapter(allAhadeth)
        binding.ahadethRecycleView.adapter = adapter
        binding.ahadethRecycleView.layoutManager = LinearLayoutManager(requireActivity())
    }

    val allAhadeth = mutableListOf<Hadeth>()

    private fun readhadethfile() {
        val fileContent = activity?.assets?.open("ahadeth.txt")?.bufferedReader()
            .use {
                it?.readText()
            }
        if (fileContent == null) return
        val ahadethContent = fileContent.trim().split("#")
        Log.d(TAG, "readhadethfile: size ${ahadethContent.size}")
        ahadethContent.forEach {
            val title = it.substringBefore('\n').trim()
            val content = it.substringAfter('\n').trim()
            val hadeth = Hadeth(title, content)
            allAhadeth.add(hadeth)

        }
    }

}