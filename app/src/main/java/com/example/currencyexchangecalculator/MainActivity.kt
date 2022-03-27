package com.example.currencyexchangecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = Html.fromHtml("<font color =\"#ffffff\">" + getString(R.string.app_name) + "</font>")
    }
}