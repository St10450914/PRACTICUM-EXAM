package com.example.practicumexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DetailedView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detailed_view)

        val textViewDisplay = findViewById<TextView>(R.id.textViewDisplay)
        val textViewAverage = findViewById<TextView>(R.id.textViewAverage)
        val btn_back = findViewById<Button>(R.id.btn_back)

        val days = intent.getStringArrayListExtra("days")
        val mins = intent.getIntegerArrayListExtra("mins")
        val maxs = intent.getIntegerArrayListExtra("maxs")
        val conditions = intent.getStringArrayListExtra("conditions")

        val detailsBuilder = StringBuilder()
        var totalTemperature = 0

        if (days != null && mins != null && maxs != null && conditions != null) {
            for (i in days.indices) {
                detailsBuilder.append("Date: ${days[i]}\n")
                detailsBuilder.append("Min temperature: ${mins[i]}\n")
                detailsBuilder.append("Max temperature: ${maxs[i]}\n")
                detailsBuilder.append(" Weather Conditions: ${conditions[i]}\n\n")
                totalTemperature += mins[i] + maxs[i]
            }

            val averageTemperature = totalTemperature / days.size
            textViewAverage.text = "Average Temperature: $averageTemperature"
        }

        textViewDisplay.text = detailsBuilder.toString()

        btn_back.setOnClickListener {
            finish()
        }
    }
}