package com.example.islamic37fri.main_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.islamic37fri.Constants
import com.example.islamic37fri.R

class SebhaFragment : Fragment() {
    lateinit var image: ImageView
    lateinit var phase: TextView
    lateinit var countertv: TextView
    var counter: Int = 0


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tasbeh_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        image = view.findViewById(R.id.img_sebha)
        countertv = view.findViewById(R.id.numbers)
        countertv.text = "$counter"
        phase = view.findViewById(R.id.phase)

        image.setOnClickListener {
            onSebhaClick()
        }


    }

    private fun onSebhaClick() {
        image.rotation = image.rotation + 5
        counter++
        countertv.text = "$counter"

        if (phase.text == Constants.Alkhatema) {
            phase.text = Constants.SuhanAllah
            counter = 0
            countertv.text = "$counter"
        }
        if (counter == 33) {
            if (phase.text == Constants.SuhanAllah) {
                phase.text = Constants.Alhamdollah
                counter = 0
                countertv.text =
                    "$counter"
            } else if (phase.text == Constants.Alhamdollah) {
                counter = 0
                phase.text = Constants.AllahAkber
            } else if (phase.text == Constants.AllahAkber) {
                phase.text = Constants.Alkhatema
                counter = 0
                countertv.text = "$counter"
            }
        }
    }
}