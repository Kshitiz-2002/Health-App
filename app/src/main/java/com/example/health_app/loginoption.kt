package com.example.health_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class loginoption : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginoption)

        val signin = findViewById<View>(R.id.signin)
        signin.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, loginoption::class.java)
            startActivity(intent)
        })
        val login = findViewById<View>(R.id.login)
        login.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, loginoption::class.java)
            startActivity(intent)
        })
    }
}