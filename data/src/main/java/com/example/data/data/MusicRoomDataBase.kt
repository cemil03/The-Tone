package com.example.data.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.data.dao.UserDao
import com.example.data.data.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = true)
abstract class MusicRoomDataBase : RoomDatabase() {

    abstract fun userDao(): UserDao
}