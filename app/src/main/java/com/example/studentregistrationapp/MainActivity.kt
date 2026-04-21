package com.example.studentregistrationapp

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etName    = findViewById<EditText>(R.id.etName)
        val spCourse  = findViewById<Spinner>(R.id.spCourse)
        val spYear    = findViewById<Spinner>(R.id.spYear)
        val rgGender  = findViewById<RadioGroup>(R.id.rgGender)
        val etEmail   = findViewById<EditText>(R.id.etEmail)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        val courses = arrayOf("BSCS", "BSIT", "BSIS", "ACT")
        val years   = arrayOf("1st Year", "2nd Year", "3rd Year", "4th Year")

        spCourse.adapter = ArrayAdapter(
            this, android.R.layout.simple_spinner_dropdown_item, courses)
        spYear.adapter = ArrayAdapter(
            this, android.R.layout.simple_spinner_dropdown_item, years)

        btnSubmit.setOnClickListener {
            val name   = etName.text.toString().trim()
            val course = spCourse.selectedItem.toString()
            val year   = spYear.selectedItem.toString()
            val email  = etEmail.text.toString().trim()
            val selectedGenderId = rgGender.checkedRadioButtonId

            if (name.isEmpty()) {
                etName.error = "Name is required"
                etName.requestFocus()
                return@setOnClickListener
            }

            if (selectedGenderId == -1) {
                Toast.makeText(this, "Please select gender",
                    Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (email.isEmpty() ||
                !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.error = "Enter a valid email"
                etEmail.requestFocus()
                return@setOnClickListener
            }

            val gender = findViewById<RadioButton>(selectedGenderId).text.toString()

            val intent = Intent(this, SummaryActivity::class.java)
            intent.putExtra("NAME",   name)
            intent.putExtra("COURSE", course)
            intent.putExtra("YEAR",   year)
            intent.putExtra("GENDER", gender)
            intent.putExtra("EMAIL",  email)
            startActivity(intent)
        }
    }
}
