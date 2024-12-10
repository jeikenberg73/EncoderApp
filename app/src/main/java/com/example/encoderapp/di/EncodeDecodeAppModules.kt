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

    // Need a module to inject the encoder decoder repository.
    @Provides
    @Singleton
    fun provideEncodeDecode() : EncodeDecodeRepository {
        return EncodeDecodeRepository.getInstance()
    }

}