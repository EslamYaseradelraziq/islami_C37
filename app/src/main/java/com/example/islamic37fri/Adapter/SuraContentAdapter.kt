package com.example.islamic37fri.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamic37fri.R

class SuraContentAdapter(var suralist: List<String?>?) :
    RecyclerView.Adapter<SuraContentAdapter.SuraContantViewHolder>() {
    var position: Int? = null
    var suraName: String? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuraContantViewHolder {

        var inflater = LayoutInflater.from(parent.context)
        var view = inflater.inflate(R.layout.item_sura_details, parent, false)
        return SuraContantViewHolder(view)
    }

    override fun onBindViewHolder(holder: SuraContantViewHolder, position: Int) {
        holder.suratext.text = suralist?.get(position)


    }

    override fun getItemCount(): Int {

        return suralist?.size ?: 0
    }

    fun updateData(suralist: List<String?>?) {
        this.suralist = suralist
        notifyDataSetChanged()

    }


    class SuraContantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val suratext: TextView

        init {
            suratext = itemView.findViewById(R.id.sura_details)

        }


    }


}