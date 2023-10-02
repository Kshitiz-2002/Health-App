package com.example.health_app

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.EditText
import android.widget.Toast

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
            //  Authorization
            var auth = false
            if(phoneNum == ""){
                Toast.makeText(applicationContext, "Please Enter Phone Number", Toast.LENGTH_SHORT).show()
            }
            else if (passWord == ""){
                Toast.makeText(applicationContext, "Please Enter Password", Toast.LENGTH_SHORT).show()
            }
            else if(auth == false){
                Toast.makeText(applicationContext, "Invalid Phone Number or Password", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this, homepage::class.java)
                startActivity(intent)
            }
        }

    }
}