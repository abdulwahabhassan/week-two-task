package com.decagon.hassan.implementation1.Implementation2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import com.decagon.hassan.implementation1.R

class Implementation2Activity : AppCompatActivity() {

    lateinit var buttonNegative:Button
    lateinit var buttonPositive:Button

    var count = 1

    //The second implementation of the task starts here. A new activity is launched by means of an intent from the main activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implementation2) //sets a new layout for this activity
        setTitle(R.string.implementation2_title)

        supportFragmentManager //this class is used to manage transaction between fragments
            .beginTransaction()
            .replace(R.id.fragmentContainer, Implementation2Fragment(count))
            .commit()

        buttonPositive = findViewById(R.id.button2) //button views are found and initialized
        buttonNegative = findViewById(R.id.button)

        buttonPositive.setOnClickListener() { //an onclick listener to add new fragments

            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainer, Implementation2Fragment(count))
                .addToBackStack(null)
                .commit()
            var textView = findViewById<TextView>(R.id.textViewFragment)
            textView.text = "Fragment ${count++}"
        }

        buttonNegative.setOnClickListener() { //An onClickListener to remove fragments from the back stack
            count--
            supportFragmentManager.popBackStack()

        }
    }

}