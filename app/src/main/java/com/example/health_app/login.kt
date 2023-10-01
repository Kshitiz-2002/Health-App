package com.example.health_app

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.EditText

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signin)
        val phnnum = findViewById<EditText>(R.id.phnum)
        val signin = findViewById<View>(R.id.sub)
        val pass = findViewById<EditText>(R.id.signpass)
        val checkbox = findViewById<View>(R.id.checkbox)
        var check = true
        checkbox.setOnClickListener{
            check = !check
            if(check==false) {
                checkbox.setBackgroundColor(Color.parseColor("#888888"))
                pass.transformationMethod = HideReturnsTransformationMethod.getInstance()

            }
            else{
                checkbox.setBackgroundColor(Color.WHITE)
                pass.transformationMethod = PasswordTransformationMethod.getInstance()
            }
            pass.setSelection(pass.text.length)
        }
        signin.setOnClickListener{
            val phoneNum = phnnum.text.toString()
            val passWord = pass.text.toString()
        }

    }
}