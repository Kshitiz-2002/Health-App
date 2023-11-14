package com.example.health_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.database.FirebaseDatabase


class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up_activity)
        val auth = FirebaseAuth.getInstance()


        val intent = intent
        val patName = intent.getStringExtra("NAME")
        val patAge = intent.getStringExtra("AGE")
        val patGender = intent.getStringExtra("GENDER")
        val patAddress = intent.getStringExtra("ADDRESS")
        val patCity = intent.getStringExtra("CITY")
        val patState = intent.getStringExtra("STATE")

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
                // Inside your else block
                val patphnnum = "+91${phnnum.text.toString()}"
                // Inside your else block
                // Inside your else block
                // Inside your else block
                auth.createUserWithEmailAndPassword(patemailid, patpass)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Store additional user information in the Realtime Database
                            val currentUser = auth.currentUser
                            val userId = currentUser?.uid
                            val database = FirebaseDatabase.getInstance().reference
                            val userMap = HashMap<String, Any>()
                            userMap["phone_number"] = patphnnum
                            database.child("users").child(userId!!).setValue(userMap)

                            // Next Activity
                            val intent = Intent(this, homepage::class.java)
                            startActivity(intent)
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                        } else {
                            Toast.makeText(
                                applicationContext,
                                "Registration failed: ${task.exception?.message}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }



            }
        }
    }
}