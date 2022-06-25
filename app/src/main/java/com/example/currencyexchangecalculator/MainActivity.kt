package com.example.currencyexchangecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Html
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onStart() {
        super.onStart()
        Log.i("Activity", "onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Activity", "onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Activity", "onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Activity", "onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Activity", "onDestroy Called")
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        Log.i("Activity", "onSaveInstanceState Called")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Activity", "onCreate Called")
        setContentView(R.layout.activity_main)
        supportActionBar?.title =
            Html.fromHtml("<font color =\"#ffffff\">" + getString(R.string.app_name) + "</font>")
    }
}