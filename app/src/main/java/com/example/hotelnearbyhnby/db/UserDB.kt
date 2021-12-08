package com.example.hotelnearbyhnby.db
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import com.example.hotelnearbyhnby.dao.UserDAO
//import com.example.hotelnearbyhnby.entity.User
//
//// For to this is database, we must annotate with @Database
//// in here @Database must includes two parameters which are entities and version
//@Database(
//    entities = [(User::class)],     // here we have two entities
//    version = 1         // version must be an integer
//)
//
//// For related class we use abstract class
//abstract class UserDB : RoomDatabase() {
//    // here we make a function and pass UserDAO
//    // created an instance of UserDAO because UserDAO is interface and we cannot make object of interface
//    // That's why we make instance of UserDAO here
//    // From this we can directly get access with UserDAO
//    // making a instance of UserDAO
//    abstract fun getUserDAO(): UserDAO
//
//    // Singleton class which means we create object only one times
//    // here directly access garna companion or static object banako
//    // While logging we have to connect and access to database, in the same way while signing up too, but
//    // to reduce we use or create companion object also known as Static object
//    companion object {
//        @Volatile       // for to make this instance available to every threads we use @Volatile
//        // here we make instance of UserDB class which is null in default
//        private var instance: UserDB? = null
//
//        fun getInstance(context: Context): UserDB {
//            if (instance == null) {
//                synchronized(UserDB::class) {
//                    instance = createDatabase(context)
//                }
//            }
//            return instance!!
//        }
//
//        // Creating a database
//        private fun createDatabase(context: Context): UserDB? {
//            return Room.databaseBuilder(
//                context.applicationContext,
//                UserDB::class.java,
//                "UserDB"
//            ).build()
//        }
//    }
//}
