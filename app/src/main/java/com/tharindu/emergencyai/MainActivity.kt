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

        val reasonInput = findViewById<EditText>(R.id.reasonInput)
        val locationInput = findViewById<EditText>(R.id.locationInput)
        val output = findViewById<TextView>(R.id.generatedText)
        val btnGenerate = findViewById<Button>(R.id.generateBtn)
        val btnSend = findViewById<Button>(R.id.sendBtn)
        val statusLog = findViewById<TextView>(R.id.statusLog)

        btnGenerate.setOnClickListener {
            val reason = reasonInput.text.toString()
            val location = locationInput.text.toString()
            val result = SOSGenerator.generateSOS(reason, location)
            output.text = result
        }

        btnSend.setOnClickListener {
            val message = output.text.toString()
            if (message.isNotEmpty()) {
                BluetoothHelper.sendMessage(message) { status ->
                    statusLog.text = status
                }
            } else {
                statusLog.text = "Generate a message first."
            }
        }
    }
}
