package com.example.practicumexam

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainScreen : AppCompatActivity() {

    private val days = mutableListOf<String>()
    private val mins = mutableListOf<Int>()
    private val maxs = mutableListOf<Int>()
    private val conditions = mutableListOf<String>()

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_screen)

        val editTextDay  = findViewById<EditText>(R.id.editTextDay)
        val editTextMin  = findViewById<EditText>(R.id.editTextMin)
        val editTextMax = findViewById<EditText>(R.id.editTextMax)
        val editTextCondition = findViewById<EditText>(R.id.editTextCondition)
        val btn_end = findViewById<Button>(R.id.btn_end)
        val btn_clear = findViewById<Button>(R.id.btn_clear)
        val btn_next = findViewById<Button>(R.id.btn_next)

            btn_next.setOnClickListener {
                val day = editTextDay.text.toString()
                val min = editTextMin.text.toString().toIntOrNull()
                val max = editTextMax.text.toString().toIntOrNull()
                val condition = editTextCondition.text.toString()

                if (day.isNotBlank() && min != null && max != null) {
                    days.add(day)
                    mins.add(min)
                    maxs.add(max)
                    conditions.add(condition)
                    Toast.makeText(this, "Entry added", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Please re-enter correct data", Toast.LENGTH_SHORT).show()
                }
            }
        btn_next.setOnClickListener {
            val intent = Intent(this, DetailedView::class.java).apply {
                putStringArrayListExtra("Day", ArrayList(days))
                putIntegerArrayListExtra("Min", ArrayList(mins))
                putIntegerArrayListExtra("Max", ArrayList(maxs))
                putStringArrayListExtra("Weather Condition", ArrayList(conditions))
            }
            startActivity(intent)
        }

        btn_clear.setOnClickListener {
            days.clear()
            mins.clear()
            maxs.clear()
            conditions.clear()
            editTextDay.text.clear()
            editTextMin.text.clear()
            editTextMax.text.clear()
            editTextCondition.text.clear()
            Toast.makeText(this, "Data cleared", Toast.LENGTH_SHORT).show()
        }

        btn_end.setOnClickListener {
            finish()
        }

    }
}