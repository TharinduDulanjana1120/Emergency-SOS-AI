package com.tharindu.emergencyai

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputMessage = findViewById<EditText>(R.id.inputMessage)
        val generatedMessage = findViewById<TextView>(R.id.generatedMessage)
        val btnGenerate = findViewById<Button>(R.id.btnGenerate)

        btnGenerate.setOnClickListener {
            val reason = inputMessage.text.toString()
            val result = SOSGenerator.generateSOS(reason)
            generatedMessage.text = result
        }
    }
}
