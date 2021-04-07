package com.decagon.hassan.implementation1.Implementation2


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.decagon.hassan.implementation1.R

//This is the fragment class

class Implementation2Fragment(count:Int) : Fragment() {

    var count = count

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {  // Inflate the layout for this fragment

        val view =  inflater.inflate(R.layout.fragment_implementation2, container, false)

        var textView:TextView = view.findViewById(R.id.textViewFragment)
        textView.text = count.toString()

        return view
    }


}