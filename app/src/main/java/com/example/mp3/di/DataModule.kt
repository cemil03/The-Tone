package com.example.mp3.di

import com.example.data.data.MusicRoomDataBase
import androidx.room.Room
import com.example.data.data.entity.UserEntity
import com.example.data.mapper.Mapper
import com.example.data.mapper.UserMapper
import com.example.data.repository.UserRepositoryImpl
import com.example.domain.entity.User
import com.example.domain.repository.UserRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataModule = module {

    factory<Mapper<UserEntity, User>> {
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

    single<UserRepository> {
        UserRepositoryImpl(dao = get(), userMapper = get())
    }

}