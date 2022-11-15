package com.example.mp3.di

import com.example.data.data.MusicRoomDataBase
import androidx.room.Room
import com.example.data.mapper.UserMapper
import com.example.data.repository.UserRepositoryImpl
import org.koin.dsl.module

val dataModule = module {

    factory {
        UserMapper()
    }

    single {
        Room.databaseBuilder(
            get(),
            MusicRoomDataBase::class.java,
            "music_database"
        ).build()
    }

    single{
        get<MusicRoomDataBase>().userDao()
    }

    single {
        UserRepositoryImpl(dao = get(), userMapper = get())
    }

}