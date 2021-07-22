package com.example.my_android_app.data.model.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
 abstract class UserDao {
 @Insert(onConflict = OnConflictStrategy.REPLACE)
 abstract suspend fun insertUser( user: UserEntity)
 @Query("SELECT * FROM user_table" )
 abstract suspend fun getAllUser(): List<UserEntity>
}