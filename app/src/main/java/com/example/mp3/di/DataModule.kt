package com.example.mp3.di

import androidx.room.Room
import com.example.data.data.MusicRoomDataBase
import com.example.data.repository.UserRepositoryImpl
import com.example.domain.repository.UserRepository
import com.example.mp3.R
import org.koin.dsl.module

val dataModule = module {

    single {
        Room.databaseBuilder(
            get(),
            MusicRoomDataBase::class.java,
            R.string.music_database.toString()
        ).build()
    }

    single{
        get<MusicRoomDataBase>().userDao()
    }

    single<UserRepository> {
        UserRepositoryImpl(dao = get())
    }

}