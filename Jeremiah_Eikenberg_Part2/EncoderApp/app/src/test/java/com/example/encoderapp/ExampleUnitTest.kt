package com.example.encoderapp

import com.example.encoderapp.data.EncodeDecodeRepository
import com.example.encoderapp.viewmodel.EncodeDecodeViewModel
import org.junit.Assert.*
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    private val encodeDecodeViewModel: EncodeDecodeViewModel =
        EncodeDecodeViewModel(EncodeDecodeRepository.getInstance())

    @Test
    fun testEncodeString() {
        val encoded = encodeDecodeViewModel.encodeString("tacocat")
        assertEquals(267487694, encoded[0])
        assertEquals(125043731, encoded[1])
    }

    @Test
    fun testGetEncodedString() {
        val encoded = encodeDecodeViewModel.encodeString("tacocat")
        val encodedString = encodeDecodeViewModel.getEncodedString(encoded)
        assertEquals("267487694, 125043731", encodedString)
    }

    @Test
    fun testDecodeString() {
        val encoded = encodeDecodeViewModel.encodeString("tacocat")
        val decoded = encodeDecodeViewModel.decodeStrings(encoded)
        assertEquals("tacocat", decoded)
    }
}