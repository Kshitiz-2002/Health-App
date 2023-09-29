package com.example.health_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class homepage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        val search = findViewById<View>(R.id.searchbar)

        search.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, searchbarflow::class.java)
            startActivity(intent)
        })

        val bookAppointment = findViewById<View>(R.id.bookappointment)
        bookAppointment.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, bookAppointment::class.java)
            startActivity(intent)
        })
//
//        val bookAppointmentIcon = findViewById<View>(R.id.bookAppointmentIcon)
//        bookAppointmentIcon.setOnClickListener(View.OnClickListener {
//            val intent = Intent(this, bookAppointment::class.java)
//            startActivity(intent)
//        })
//        val bookAppointmentText1 = findViewById<View>(R.id.book_an_app)
//        bookAppointmentText1.setOnClickListener(View.OnClickListener {
//            val intent = Intent(this, bookAppointment::class.java)
//            startActivity(intent)
//        })
//        val bookAppointmentText2 = findViewById<View>(R.id.nursing_fac)
//        bookAppointmentText2.setOnClickListener(View.OnClickListener {
//            val intent = Intent(this, bookAppointment::class.java)
//            startActivity(intent)
//        })

    }
}