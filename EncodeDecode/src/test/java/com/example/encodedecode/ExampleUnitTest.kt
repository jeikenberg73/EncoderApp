package com.example.encodedecode

import com.example.encodedecode.DecodeString.decodeString
import com.example.encodedecode.EncodeString.encodeString
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun encodeTest() {
        assertEquals(251792692, encodeString("FRED"))
    }

    @Test
    fun decodeTest() {
        assertEquals("FRED", decodeString(251792692))
    }

    @Test
    fun encodeTest2() {
        assertEquals(125043731, encodeString("cat"))
    }

    @Test
    fun decodeTest2() {
        assertEquals("cat", decodeString(125043731))
    }

    @Test
    fun encodeTest3() {
        assertEquals(141566276, encodeString("\$(#@"))
    }

    @Test
    fun decodeTest3() {
        assertEquals("\$(#@", decodeString(141566276))
    }

    @Test
    fun encodeTest4() {
        assertEquals(150208524, encodeString("  1aar*("))
    }

    @Test
    fun decodeTest4() {
        assertEquals("  1a", decodeString(150208524))
    }
}