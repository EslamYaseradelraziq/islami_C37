package com.example.islamic37fri.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamic37fri.CallBacks.onSuraClickListener
import com.example.islamic37fri.R

class SuraNamesAdapter(var sura: List<String>, var count: Int = 23) :
    RecyclerView.Adapter<SuraNamesAdapter.SurasNamesViewHolder>() {


    var onSuraClickListener: onSuraClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurasNamesViewHolder {

        var inflater = LayoutInflater.from(parent.context)
        var view = inflater.inflate(R.layout.quran_list_item, parent, false)


        return SurasNamesViewHolder(view)


    }

    override fun onBindViewHolder(holder: SurasNamesViewHolder, position: Int) {

        holder.suraname.text = sura.get(position)
        holder.suracontent.text = "$count"
        holder.itemView.setOnClickListener {
            onSuraClickListener?.onSuraClick(position, sura.get(position))
        }
    }

    override fun getItemCount(): Int {
        return sura.size
    }

    class SurasNamesViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        var suraname: TextView
        var suracontent: TextView

        init {
            suraname = itemView.findViewById(R.id.sura_name)
            suracontent = itemView.findViewById(R.id.sura_content_count)
        }

    }


}