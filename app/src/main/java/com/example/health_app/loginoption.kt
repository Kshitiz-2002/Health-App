package com.example.health_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class loginoption : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginoption)

        val signin = findViewById<View>(R.id.login)
        signin.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        })
    }
}