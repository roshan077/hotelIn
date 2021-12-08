package com.example.hotelnearbyhnby.dao
//
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.Query
//import com.example.hotelnearbyhnby.entity.User
//
//// all the queries are present in this interface
//// queries are like 'select * from table and delete' like in other database
//// but we don't have to put queries like other databases.
//
//@Dao
//interface UserDAO {
//    // in user table we have five parameters
//    // in other databases we have to put all five parameters like this
//    // fun registerUser(fname: String, lname: String,..........)
//    // But we can use here only User because all the parameters are in User class
//
//    @Insert
//    // suspend sinks this functions with coroutines, It won't run or execute until coroutines launch
//    suspend fun registerUser(user: User)
//
//    @Query("Select * from User")
//    suspend fun getAllUser(): List<User>
//
//    @Query("Select * from User where username = (:username) and password=(:password)")
//    suspend fun checkUser(username: String, password: String): User
//}