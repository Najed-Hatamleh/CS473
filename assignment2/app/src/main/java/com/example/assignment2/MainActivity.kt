package com.example.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private val array: MutableList<String> = mutableListOf("Pizza", "Mexican", "Hamburger",  "American", "Chinese", "Mediterranean")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val addFoodEditText = findViewById<EditText>(R.id.addfood_et)
        val addFoodBtn      = findViewById<Button>(R.id.addfood_btn)
        val decideBtn       = findViewById<Button>(R.id.decide_btn)
        val foodSelectedTV  = findViewById<TextView>(R.id.foodSelectedTV)

        decideBtn.setOnClickListener {
            val randomIndex   = Random.nextInt(array.size);
            val randomElement = array[randomIndex]
            foodSelectedTV.text = randomElement
        }

        addFoodBtn.setOnClickListener {
            if(addFoodEditText.text.isNotEmpty() && addFoodEditText.text.trim().isNotEmpty())
                addFoodEditText.text?.let {
                    array.add(addFoodEditText.text.toString())
                }
            addFoodEditText.text.clear()
        }
    }
}