package com.example.hotelnearbyhnby.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.hotelnearbyhnby.R
//import com.example.hotelnearbyhnby.db.UserDB
//import com.example.hotelnearbyhnby.entity.User
import com.example.hotelnearbyhnby.model.User
import com.example.hotelnearbyhnby.repository.UserRepository
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignupActivity : AppCompatActivity() {
    private lateinit var textInputEditTextUsername: TextInputEditText
    private lateinit var textInputEditTextEmail: TextInputEditText
    private lateinit var textInputEditTextPassword: TextInputEditText
    private lateinit var textInputEditTextConfirmPassword: TextInputEditText
    private lateinit var btnSignUp: Button
    private lateinit var tvSignIn: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        //binding
        textInputEditTextUsername = findViewById(R.id.textInputEditTextUsername)
        textInputEditTextEmail = findViewById(R.id.textInputEditTextEmail)
        textInputEditTextPassword = findViewById(R.id.textInputEditTextPassword)
        textInputEditTextConfirmPassword = findViewById(R.id.textInputEditTextConfirmPassword)
        btnSignUp = findViewById(R.id.btnSignUp)
        tvSignIn = findViewById(R.id.tvSignIn)

        // set action click listener
        btnSignUp.setOnClickListener {
//            validation()
            signUp()
        }

        tvSignIn.setOnClickListener {
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    /* -------------------------Functions part--------------------------------------- */
    // validation
    private fun validation() {
        if (TextUtils.isEmpty(textInputEditTextUsername.text)) {
            textInputEditTextUsername.error = "Field must not be empty"
            textInputEditTextUsername.requestFocus()
            return
        } else if (TextUtils.isEmpty(textInputEditTextPassword.text)) {
            textInputEditTextPassword.error = "Field must not be empty"
            textInputEditTextPassword.requestFocus()
            return
        }

        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    // after clicking on signup button
    private fun signUp() {
        val username = textInputEditTextUsername.text.toString()
        val email = textInputEditTextEmail.text.toString()
        val password = textInputEditTextPassword.text.toString()
        val confirmPassword = textInputEditTextConfirmPassword.text.toString()

        if (password != confirmPassword) {
            textInputEditTextPassword.error = "Password does not match"
            textInputEditTextPassword.requestFocus()
//            return
        } else {
            //Insert user to Room database
            val user = User(username = username, email = email, password = password)

            Toast.makeText(this@SignupActivity, "Registered", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@SignupActivity, LoginActivity::class.java))

            CoroutineScope(Dispatchers.IO).launch {
//                UserDB.getInstance(this@SignupActivity)
//                    .getUserDAO().registerUser(user)
//
//                // switch to main thread
//                withContext(Dispatchers.Main) {
//                    Toast.makeText(this@SignupActivity, "User Added", Toast.LENGTH_SHORT).show()
//                }

                try {
                    val repository = UserRepository()
                    val response = repository.registerUser(user)
                    if (response.success == true) {
                        withContext(Main) {

                        }
                    }
                } catch (ex: Exception) {
                    withContext(Main) {
                        Toast.makeText(this@SignupActivity, ex.toString(), Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }



        }
    }
}