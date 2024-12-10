package com.example.encoderapp.data

import com.example.encodedecode.DecodeString
import com.example.encodedecode.EncodeString

class EncodeDecodeRepository {
    companion object {
        @Volatile
        private var INSTANCE: EncodeDecodeRepository? = null

        fun getInstance() =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: EncodeDecodeRepository().also { INSTANCE = it }
            }
    }

    fun encodeData(string: String): Int = EncodeString.encodeString(string)

    fun decodeData(int: Int): String = DecodeString.decodeString(int)
}