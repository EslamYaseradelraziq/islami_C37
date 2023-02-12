package com.example.islamic37fri

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamic37fri.databinding.ItemHadethBinding

class HadethTitleRecycleAdapter(val items: List<Hadeth>) :
    RecyclerView.Adapter<HadethTitleRecycleAdapter.ViewHolder>() {

    class ViewHolder(val viewbinding: ItemHadethBinding) :
        RecyclerView.ViewHolder(viewbinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val viewbinding = ItemHadethBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(viewbinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewbinding.title.text = items[position].title
        Log.d(TAG, "onBindViewHolder:item title =  ${items[position].title}")
        Log.d(TAG, "onBindViewHolder:item content =  ${items[position].content}")
    }

    override fun getItemCount(): Int {
        return items.size
    }

    companion object {
        private const val TAG = "HadethTitleRecycleAdapt"
    }
}