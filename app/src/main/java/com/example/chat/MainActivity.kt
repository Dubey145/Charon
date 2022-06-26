package com.example.chat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var register : Button
    private lateinit var switch_login : Button
    private lateinit var username : TextView
    private lateinit var password : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        register = findViewById(R.id.login)
        switch_login = findViewById(R.id.switch_login)

        username = findViewById<TextView>(R.id.user_login)
        password = findViewById<EditText>(R.id.password_login)

        register.setOnClickListener {

                perform_register()
           }

        switch_login.setOnClickListener {
                //to launch login activity
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }

    private fun perform_register()
    {
        var temp = username.text.toString()
        val pass = password.text.toString()
        if (temp.isEmpty() || pass.isEmpty()) {
            Toast.makeText(
                baseContext, "fields can't be empty",
                Toast.LENGTH_SHORT
            ).show()
            return
        }
        val user = temp + "@xyz.com"

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(user, pass)
            .addOnCompleteListener {
                if (!it.isSuccessful) {
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@addOnCompleteListener
                }
                //Log.d("Login","Successfully logged in: ${it.result!!.user?.uid}")
                Toast.makeText(
                    baseContext, "Authentication succcessful.",
                    Toast.LENGTH_SHORT
                ).show()

            }
    }
}