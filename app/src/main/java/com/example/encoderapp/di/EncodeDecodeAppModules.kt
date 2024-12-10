package com.example.encoderapp.di

import com.example.encoderapp.data.EncodeDecodeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object EncodeDecodeModules {

    @Provides
    @Singleton
    fun provideEncodeDecode() : EncodeDecodeRepository {
        return EncodeDecodeRepository.getInstance()
    }

}