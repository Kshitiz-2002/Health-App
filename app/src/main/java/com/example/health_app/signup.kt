package com.example.health_app

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup)

        val male = findViewById<View>(R.id.ellipse_2)
        val female = findViewById<View>(R.id.ellipse_3)
        val other = findViewById<View>(R.id.ellipse_4)
        val next = findViewById<View>(R.id.next)
        val name = findViewById<EditText>(R.id.name)
        val age  = findViewById<EditText>(R.id.age)
        val add = findViewById<EditText>(R.id.patadd)
        val city = findViewById<EditText>(R.id.citytext)
        val state = findViewById<EditText>(R.id.statetext)
        var gender = "None"
        male.setOnClickListener{
            gender = "Male"
            female.setBackgroundColor(Color.WHITE)
            other.setBackgroundColor(Color.WHITE)
            male.setBackgroundColor(Color.parseColor("#888888"))
        }
        female.setOnClickListener{
            gender = "Female"
            male.setBackgroundColor(Color.WHITE)
            other.setBackgroundColor(Color.WHITE)
            female.setBackgroundColor(Color.parseColor("#888888"))
        }
        other.setOnClickListener{
            gender = "Other"
            male.setBackgroundColor(Color.WHITE)
            female.setBackgroundColor(Color.WHITE)
            other.setBackgroundColor(Color.parseColor("#888888"))
        }
        next.setOnClickListener {
            val patname = name.text.toString()
            val patage = age.text.toString()
            val pataddress = add.text.toString()
            val patcity = city.text.toString()
            val patstate = state.text.toString()

            if(patname == ""){
                Toast.makeText(applicationContext, "Please Enter Name", Toast.LENGTH_SHORT).show()
            }
            else if(patage == ""){
                Toast.makeText(applicationContext, "Please Enter Age", Toast.LENGTH_SHORT).show()
            }
            else if(gender == "None"){
                Toast.makeText(applicationContext, "Please Select Gender", Toast.LENGTH_SHORT).show()
            }
            else if(pataddress == ""){
                Toast.makeText(applicationContext, "Please Enter Address", Toast.LENGTH_SHORT).show()
            }
            else if(patcity == ""){
                Toast.makeText(applicationContext, "Please Enter City", Toast.LENGTH_SHORT).show()
            }
            else if(patstate == ""){
                Toast.makeText(applicationContext, "Please Enter State", Toast.LENGTH_SHORT).show()
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