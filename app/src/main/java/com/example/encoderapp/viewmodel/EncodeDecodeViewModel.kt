package com.example.encoderapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.encoderapp.data.EncodeDecodeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * This viewmodel is used to take in a string and retrieve the encoded decimal values from the
 * encoder in the repository. Then the viewmodel use the decimal values to retrieve the original
 * string from the decoder in the repository.
 * @param encodeDecodeRepository: this is the injected repository to encode and decode a string.
 */
@HiltViewModel
class EncodeDecodeViewModel @Inject constructor(
    private val encodeDecodeRepository: EncodeDecodeRepository
) : ViewModel() {

    /**
     * This function takes in a string and uses the repositories encoder to receive a list of
     * decimals that represent the encoded binary string.
     * @param str The string to be encoded.
     * @return A list of decimals that represent the encoded binary string.
     */
    fun encodeString(str: String): Array<Int> {

        // Create a mutable list to hold the list of decimals.
        val encodedValues = mutableListOf<Int>()

        // Split the string into 4 character chunks. This is because the encoder works only with
        // 32 bit section.
        val chunkedString = str.chunked(4)

        // Take each chunk and get the encoded decimal value from the encoder and add it to the
        // list.
        for (nextChunk in chunkedString) {
            val encodedValue = encodeDecodeRepository.encodeData(nextChunk)
            encodedValues.add(encodedValue)
        }

        // Return the list of encoded decimal values.
        return encodedValues.toTypedArray()
    }

    //
    /**
     * This function creates a string of the encoded decimal values.
     * @param arr This is the list of encoded decimals that came from the encoder.
     * @return Returns a string that consists of all the decimals that represent the encoded
     * binary string.
     */
    fun getEncodedString(arr: Array<Int>): String {
        // Create a StringBuilder to construct the string.
        val sb = StringBuilder()
        // For each decimal in the array add a space to the front and a comma at the end and append
        // it to the string.
        for (nextEncodedValue in arr) {
            sb.append(" $nextEncodedValue,")
        }
        // Remove the extra space at the beginning and the extra comma at the end and build the
        // string. Return the resulting string.
        return sb.toString().drop(1).dropLast(1)
    }

    /**
     * This function takes the list of encoded decimals and decodes them back into the original
     * string.
     * @param arr This is the list of encoded decimals from the encoder.
     * @return Returns the original string decoded from the encoded decimals.
     */
    fun decodeStrings(arr: Array<Int>): String {
        val sb = StringBuilder()
        for (nextString in arr) {
            sb.append(encodeDecodeRepository.decodeData(nextString))
        }

        return sb.toString()
    }
}