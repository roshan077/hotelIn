package com.example.hotelnearbyhnby.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hotelnearbyhnby.R
import com.example.hotelnearbyhnby.model.User
//import com.example.hotelnearbyhnby.db.UserDB
//import com.example.hotelnearbyhnby.entity.User
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {
    var username: String? = ""
    var password: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        startActivity(Intent(this@SplashActivity, LoginActivity::class.java))

//        getUsernamePassword()
//        login()

        /*  for background process, we are going to use IO
            for frontend process (UI), we are going to use Main
            here we are going to use Main thread
         */

//        CoroutineScope(Dispatchers.Main).launch {
//            delay(1000)
//            startActivity(
//                Intent(this@SplashActivity, LoginActivity::class.java)
//            )
//            finish()
//        }

    }

    private fun getUsernamePassword() {
        val sharedPreferences = getSharedPreferences("usernamePasswordPref", MODE_PRIVATE)
        /*
            In loginActivity, we use putExtra to put, here we use getString to get that data
            For key, we need to pass key and defValue which is null here
            means in case of not getting username or password
         */
        username = sharedPreferences.getString("username", "")
        password = sharedPreferences.getString("password", "")
    }

    private fun login() {
//        var user: User? = null

        CoroutineScope(Dispatchers.IO).launch {
//            delay(1000)
//            user =
//                UserDB.getInstance(this@SplashActivity).getUserDAO().checkUser(username!!, password!!)
//
//            if (user == null) {
//                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
//            } else {
//                startActivity(Intent(this@SplashActivity, DashboardActivity::class.java))
//            }
        }
    }
}
