package com.example.data.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.data.dao.UserDao
import com.example.data.data.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = true)
abstract class MusicRoomDataBase : RoomDatabase() {

    abstract fun UserDao(): UserDao

    companion object {
        private var INSTANCE: MusicRoomDataBase? = null

        fun getDataBase(context: Context): MusicRoomDataBase {
            val tmpInstance = INSTANCE
            if (tmpInstance != null) {
                return tmpInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MusicRoomDataBase::class.java,
                    "music_database"
                ).build()
                INSTANCE = instance
                return instance
            }

        }


    }


}