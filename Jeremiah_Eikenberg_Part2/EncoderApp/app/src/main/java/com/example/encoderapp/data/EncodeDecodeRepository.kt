package com.example.encoderapp.data

import com.example.encodedecode.DecodeString
import com.example.encodedecode.EncodeString

/**
 * This repository is used to pass a string to the encoder and pass encoded values from the decoder
 * back to the requesting source.
 */
class EncodeDecodeRepository {
    // Need an instance to act as a singleton so that we don't get multiple repositories.
    companion object {
        @Volatile
        private var INSTANCE: EncodeDecodeRepository? = null

        fun getInstance() =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: EncodeDecodeRepository().also { INSTANCE = it }
            }
    }

    // Function to pass a string to the encoder and get the resulting decimal.
    fun encodeData(string: String): Int = EncodeString.encodeString(string)

    // Function to pass the decimal value to the decoder and get the resulting string.
    fun decodeData(int: Int): String = DecodeString.decodeString(int)
}