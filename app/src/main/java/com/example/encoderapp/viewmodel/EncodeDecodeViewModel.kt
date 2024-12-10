package com.example.encoderapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.encoderapp.data.EncodeDecodeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class EncodeDecodeViewModel @Inject constructor(
    private val encodeDecodeRepository: EncodeDecodeRepository
) : ViewModel() {

    fun encodeString(str: String): Array<Int> {
        val encodedValues = mutableListOf<Int>()
        val chunkedString = str.chunked(4)
        for (nextChunk in chunkedString) {
            val encodedValue = encodeDecodeRepository.encodeData(nextChunk)
            encodedValues.add(encodedValue)
        }

        return encodedValues.toTypedArray()
    }

    fun getEncodedString(arr: Array<Int>): String {
        val sb = StringBuilder()
        for (nextEncodedValue in arr) {
            sb.append(" $nextEncodedValue,")
        }
        return sb.toString().drop(1).dropLast(1)
    }

    fun decodeStrings(arr: Array<Int>): String {
        val sb = StringBuilder()
        for (nextString in arr) {
            sb.append(encodeDecodeRepository.decodeData(nextString))
        }

        return sb.toString()
    }
}