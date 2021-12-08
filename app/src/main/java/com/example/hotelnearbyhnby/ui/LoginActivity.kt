package com.example.hotelnearbyhnby.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.*
import com.example.hotelnearbyhnby.R
import com.example.hotelnearbyhnby.api.ServiceBuilder
import com.example.hotelnearbyhnby.repository.UserRepository
import com.google.android.material.snackbar.Snackbar
//import com.example.hotelnearbyhnby.db.UserDB
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginActivity : AppCompatActivity() {
    private lateinit var textInputEditTextUsername: TextInputEditText
    private lateinit var textInputEditTextPassword: TextInputEditText
    private lateinit var btnLogin: Button
    private lateinit var tvForgotYourPassword: TextView
    private lateinit var tvCreateNew: TextView
    private lateinit var scrollView: ScrollView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // binding
        textInputEditTextUsername = findViewById(R.id.textInputEditTextUsername)
        textInputEditTextPassword = findViewById(R.id.textInputEditTextPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvForgotYourPassword = findViewById(R.id.tvForgotYourPassword)
        tvCreateNew = findViewById(R.id.tvCreateNew)
        scrollView = findViewById(R.id.scrollView)

        // setup action listener
        btnLogin.setOnClickListener {
            validation()
            login()
        }

        tvCreateNew.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }

    /* --------------------------------Functions parr-------------------------------- */
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
    }

    // after clicking on signIn button
    private fun login() {
        val username = textInputEditTextUsername.text.toString()
        val password = textInputEditTextPassword.text.toString()

        CoroutineScope(Dispatchers.IO).launch {
//            val user =
//                UserDB.getInstance(this@LoginActivity).getUserDAO().checkUser(username, password)
//
//            if (user == null) {
//                withContext(Dispatchers.Main) {
//                    Toast.makeText(this@LoginActivity, "Invalid credentials", Toast.LENGTH_SHORT)
//                        .show()
//                }
//            } else {
//                // we save small data in share preferences like setting data
//                // save username and password to shared preferences
//                // we make function here
//                saveUsernameAndPassword()
//
//                Toast.makeText(
//                    this@LoginActivity,
//                    "You are successfully login.",
//                    Toast.LENGTH_SHORT
//                ).show()
//
//                startActivity(Intent(this@LoginActivity, DashboardActivity::class.java))


            try {
                val repository = UserRepository()
                val response = repository.login(username, password)
                if (response.success == true) {
                    // Save token
                    ServiceBuilder.token = "Bearer ${response.token}"
                    ServiceBuilder.userid = response.userid
                    //Save username and password in shared preferences
                    // saveUsernamePassword()
                    startActivity(
                        Intent(
                            this@LoginActivity, DashboardActivity::class.java
                        )
                    )
                    finish()
                } else {
                    withContext(Dispatchers.Main) {
                        val snack =
                            Snackbar.make(
                                scrollView,
                                "Invalid credentials",
                                Snackbar.LENGTH_LONG
                            )
                        snack.setAction("OK", View.OnClickListener {
                            snack.dismiss()
                        })
                        snack.show()
                    }
                }
            } catch (ex: Exception) {
                withContext(Dispatchers.Main) {
                    Log.d("Error", ex.toString())
                    Toast.makeText(
                        this@LoginActivity,
                        ex.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }
    }
}

//private fun saveUsernameAndPassword() {
    /* instance of SharedPreferences
        two parameter i.e. 1st: name of Preferences and 2: Mode
        Like while create database, folder also created inside Device File Explorer
        In the same way, inside Preferences folder create file in the name of given 1st parameter name,
        here is "usernamePasswordPref"
        File will be created in XML file because we have to keep data inside key and value pair,
        it won't worked on JSON
        2nd parameter: MODE_PRIVATE means only this app can use it while others can't.
        We need to things, SharedPreferences and editor
        For example:
        In notepad, after writing something and click on don't save, it won't save anything
        in this way, editor is like notepad and we must save it make it permanent that's why we
        use editor.apply()
    */

//    val sharedPreferences = getSharedPreferences("usernamePasswordPref", MODE_PRIVATE)
//    val editor = sharedPreferences.edit()
//
//    editor.putString("username", textInputEditTextUsername.text.toString())
//    editor.putString("password", textInputEditTextPassword.text.toString())
//
//    editor.apply()
//}

