package com.decagon.hassan.implementation1

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.decagon.hassan.implementation1.Implementation2.Implementation2Activity

//Main Activity, this is the entry point of the app from launch

class MainActivity : AppCompatActivity() {

    private val tag = "mainActivityLog"

    lateinit var textView1:TextView  //Late initialization to hold references to views in the main activity
    lateinit var textView2:TextView
    lateinit var button1:Button

    var portraitCount = 0 //variables to keep count of orientation change
    var landscapeCount = 0

    override fun onCreate(savedInstanceState: Bundle?) { //Initialization is done during the onCreate state
        super.onCreate(savedInstanceState)
        Log.i(tag, "OnCreate")
        Toast.makeText(this, R.string.on_create, Toast.LENGTH_SHORT ).show()
        setContentView(R.layout.activity_main) //A defined layout is used to set the contentView of this activity

        textView1 = findViewById(R.id.textView1) //These find the views by ids in the specified res.layout of the main activity
        textView2 = findViewById(R.id.textView2)
        button1 = findViewById(R.id.button1)

        textView1.setText(R.string.on_create) //The value of textview1 changes with respect to the current state in the lifecycle of the app

        button1.setOnClickListener() { //onClick listener is used to captured an explicit user's intent to start the next activity
            val implementation2Intent = Intent(this, Implementation2Activity::class.java)
            startActivity(implementation2Intent)
        }

    }

    override fun onSaveInstanceState(outState: Bundle) { //This function is called just after onStop, it used to capture per instance state of an activity when the activity loses priority in the app foreground
        super.onSaveInstanceState(outState)

        outState.putInt("portraitCount", portraitCount) // key-value pair to store data in the bundle
        outState.putInt("landscapeCount", landscapeCount)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) { //This method is called just before resume and pro-Oncreate and used to restore per instance state of an activity before it lost priority in the foreground
        super.onRestoreInstanceState(savedInstanceState)

        portraitCount = savedInstanceState.getInt("portraitCount")
        landscapeCount = savedInstanceState.getInt("landscapeCount")
    }

    override fun onStart() { //The rest of the states below basically contains logs and toasts which can be used for debugging and tracking what state this activity is currently in
        super.onStart()
        Log.i(tag, "OnStart")
        Toast.makeText(this, R.string.on_start, Toast.LENGTH_SHORT).show()
        textView1.setText(R.string.on_start)

    }

    override fun onResume() {
        super.onResume()
        Log.i(tag, "OnResume")
        Toast.makeText(this, R.string.on_resume, Toast.LENGTH_SHORT).show()
        textView1.setText(R.string.on_resume)


        if (this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            portraitCount++
            textView2.text = "Portrait mode ($portraitCount)"
        } else if (this.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            landscapeCount++
            textView2.text = "LandScape mode ($landscapeCount)"
        }
    }

    override fun onPause() {
        super.onPause()
        Log.i(tag, "OnPause")
        Toast.makeText(this, R.string.on_pause, Toast.LENGTH_SHORT).show()
        textView1.setText(R.string.on_pause)
    }

    override fun onStop() {
        super.onStop()
        Log.i(tag, "OnStop")
        Toast.makeText(this, R.string.on_stop, Toast.LENGTH_SHORT).show()
        textView1.setText(R.string.on_stop)
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.i(tag, "OnDestroy")
        Toast.makeText(this, R.string.on_destroy, Toast.LENGTH_SHORT).show()
        textView1.setText(R.string.on_destroy)
    }

}