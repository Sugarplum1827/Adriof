package com.example.studentregistrationapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SummaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        val tvSummary = findViewById<TextView>(R.id.tvSummary)

        val name   = intent.getStringExtra("NAME")
        val course = intent.getStringExtra("COURSE")
        val year   = intent.getStringExtra("YEAR")
        val gender = intent.getStringExtra("GENDER")
        val email  = intent.getStringExtra("EMAIL")

        tvSummary.text = """
            Registration Summary

            Name:       $name
            Course:     $course
            Year Level: $year
            Gender:     $gender
            Email:      $email
        """.trimIndent()
    }
}
