package com.currencyexchangeapp.currencyexchangecalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //add toolbar
        setSupportActionBar(findViewById(R.id.toolbar))
    }
}