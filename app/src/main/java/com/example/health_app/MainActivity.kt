package com.example.health_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.startuppage)
        val getStarted = findViewById<View>(R.id.submitBox)

        getStarted.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, loginoption::class.java)
            startActivity(intent)
        })
    }
}