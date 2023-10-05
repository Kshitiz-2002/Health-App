package com.example.health_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class signup2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup2)

        val phnnum = findViewById<EditText>(R.id.phnnumbox)
        val emailid = findViewById<EditText>(R.id.emailidbox)
        val pass = findViewById<EditText>(R.id.passbox)
        val cpass = findViewById<EditText>(R.id.cpass)
        val sub = findViewById<View>(R.id.submit)

        sub.setOnClickListener {
            val patphnnum = phnnum.text.toString()
            val patemailid = emailid.text.toString()
            val patpass = pass.text.toString()
            val patcpass = cpass.text.toString()

            if(patphnnum== ""){
                Toast.makeText(applicationContext, "Please Enter Phone Number", Toast.LENGTH_SHORT).show()
            }
            else if(patphnnum.length>10){
                Toast.makeText(applicationContext, "Please Enter Valid Phone Number", Toast.LENGTH_SHORT).show()
            }
            else if(patemailid == ""){
                Toast.makeText(applicationContext, "Please Enter EmailId", Toast.LENGTH_SHORT).show()
            }
            else if(patpass != patcpass){
                Toast.makeText(applicationContext, "Password and Confirm password doesn't match", Toast.LENGTH_SHORT).show()
            }
            else if(patpass == ""){
                Toast.makeText(applicationContext, "Please Enter Password", Toast.LENGTH_SHORT).show()
            }
            else if(patcpass == ""){
                Toast.makeText(applicationContext, "Please Enter Confirm Password", Toast.LENGTH_SHORT).show()
            }
            else{
                //  Registration
                //  Next Activity
                val intent = Intent(this, homepage::class.java)
                startActivity(intent)
            }
        }
    }
}