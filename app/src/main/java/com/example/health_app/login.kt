package com.example.health_app

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider

class login : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private var storedVerificationId: String? = null
    private lateinit var resendToken: PhoneAuthProvider.ForceResendingToken

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signin)

        auth = FirebaseAuth.getInstance()

        val phnnum = findViewById<EditText>(R.id.phnum)
        val signin = findViewById<View>(R.id.signup)
        val pass = findViewById<EditText>(R.id.signpass)
        val checkbox = findViewById<View>(R.id.checkbox)
        val signup = findViewById<View>(R.id.sub)
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
            var auth = true
            if(phoneNum == ""){
                Toast.makeText(applicationContext, "Please Enter Phone Number", Toast.LENGTH_SHORT).show()
            }
            else if (passWord == ""){
                Toast.makeText(applicationContext, "Please Enter Password", Toast.LENGTH_SHORT).show()
            }
            else{
                val phoneNum = phnnum.text.toString().trim()
                val options = PhoneAuthProvider
                    .getInstance()
                    .verifyPhoneNumber(
                        phoneNum,
                        60,
                        java.util.concurrent.TimeUnit.SECONDS,
                        this,
                        object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                                // This callback will be invoked in two situations:
                                // 1 - Instant verification.
                                // 2 - Auto-retrieval.
                                signInWithPhoneAuthCredential(credential)
                            }

                            override fun onVerificationFailed(e: FirebaseException) {
                                Toast.makeText(
                                    applicationContext,
                                    "Verification Failed: ${e.message}",
                                    Toast.LENGTH_SHORT
                                ).show()
                                print(e.message)
                            }

                            override fun onCodeSent(
                                verificationId: String,
                                token: PhoneAuthProvider.ForceResendingToken
                            ) {
                                storedVerificationId = verificationId
                                resendToken = token
                            }
                        })

            }
        }
        signup.setOnClickListener{
            val intent = Intent(this, SignupPage::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_top)
        }
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this, homepage::class.java)
                    startActivity(intent)
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Authentication failed: ${task.exception?.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
    override fun onBackPressed() {
        // Do nothing (block the back button)
    }
}