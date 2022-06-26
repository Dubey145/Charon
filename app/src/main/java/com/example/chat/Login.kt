package com.example.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    private lateinit var user_login : TextView
    private lateinit var password_login: EditText

    private lateinit var login : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        user_login = findViewById<TextView>(R.id.user_login)
        password_login = findViewById<EditText>(R.id.password_login)
        login = findViewById(R.id.login)

    }
private fun perform_login(){
    var temp = user_login.text.toString()
    val user = temp+"@xyz.com"
    val pass = password_login.text.toString()
    FirebaseAuth.getInstance().signInWithEmailAndPassword(user,pass)
        //.addOnCompleteListener()

}
}