package com.example.encodedecode

import java.util.BitSet

object DecodeString {
    /**
     * This function takes in an integer representing a decoded string and returns the original string.
     * @param encodedInt: This is the integer representing the encoded original string.
     * @return Then original string that was decoded.
     */
    fun decodeString(encodedInt: Int): String {

        // Create a binary string from the encoded integer.
        val bitString = Integer.toBinaryString(encodedInt)

        // Create a bitset to put the decoded binary string in after decoding it.
        val result = BitSet()
        // An index that acts as a pointer to the next character in the binary string to work on.
        var i = 1
        // An index that is used to represent the next index in the character set we are looking at.
        var adjustIndex = 0
        // An index that is used to represent the next character set we are looking at.
        var charIndex = 0

        // Iterate through the binary string in reverse and decode the string to a bitset.
        bitString.reversed().forEach { nextChar ->
            // Convert the next character in the binary string to an integer.
            val nextBit = nextChar.digitToInt()
            // If the next character is a 1, set the appropriate bit in the bitset based on the current
            //  character index and adjusted index.
            if (nextBit == 1) {
                result.set(adjustIndex + charIndex)
            }
            // Increase the character index to the next character set
            charIndex += 8
            // If the pointer is at a factor of 4, reset the character index to 0 and increase the
            //  adjusted index to the next position.
            if (i % 4 == 0) {
                charIndex = 0
                adjustIndex++
            }
            // Move the pointer to the next position.
            i++
        }
        // Create a string builder to put the converted string into.
        val sb = StringBuilder()
        // Iterate through the bitset. Append a 1 or 0 according to the next bit in the bitset.
        for (nextValue in 0 until result.size()) {
            sb.append(if (result[nextValue]) '1' else '0')
        }
        // Create the string from the String builder.
        var resultString = sb.toString()
        // Remove the extra 0's from the end of the string.
        resultString = resultString.substring(0, 32)
        // Reverse the string so that we can convert it into a readable string.
        resultString = resultString.reversed()
        // Divide up the string into bytes and create a byte array out of them.
        val byteArray = resultString.chunked(8).map { it.toInt(2).toByte() }.toByteArray()
        // Convert each byte into its equivalent character based on the UTF_8 standard.
        var finalString = String(byteArray, Charsets.UTF_8)
        // Reverse the string back to its original orientation.
        finalString = finalString.reversed()
        // Remove any null characters
        finalString = finalString.replace("\u0000", "")
        // Return the original string.
        return finalString
    }
}