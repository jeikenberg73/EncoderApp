package com.example.encodedecode

import java.util.BitSet

object EncodeString {
    /**
     * This function takes in a string and encodes it according to the Art + Logic guide lines for
     * their first programing challenge.
     * @param str: this is the string to encode. This function only takes 4 characters at a time.
     * @return the function returns a decimal value that generated from the bitset that is created
     *  by encoding the string.
     */
    fun encodeString(str: String): Int {
        var truncatedStr = str
        if (str.length > 4) {
            truncatedStr = str.substring(0, 4)
        }
        // Create BitSet to hold the encoded bits
        val result = BitSet(32)

        // This is the index that tells the algorithm which character we are working on
        var byteIndex = 0

        // Loop through each character in the string
        for (char in truncatedStr) {

            // Loop through each bit in the character starting from the most significant bit down to
            // the least significant. If the bit is a 1 set the 4th bit shifted left times the index
            // of the bit being examined (e.g. 7th bit in the character is shifted 7 * 4 = 28).
            // Then for each character after the first add another shift to the left to the bit
            // (e.g. 2nd character add 1 shift to the left, 3rd character add 2 shifts to the left, etc.).
            for (i in 7 downTo 0) {

                // Get the bit value at the index
                val bit = (char.code shr i) and 1

                // If the bit is a 1 set the appropriate bit in the resulting bitset.
                if (bit == 1) {

                    // Set the bit in the resulting bitset to 1 at the index that is the current
                    //  character's bit index times 4 and then add the number of characters that have
                    //  been evaluated.
                    result.set((i * 4) + byteIndex)
                }
            }

            // Increase the value of the number of characters that have been evaluated.
            byteIndex++
        }

        // Create an integer that will hold the decimal equivalent of the resulting bitset.
        var resultInt = 0

        // Loop through the resulting bitset and for each 1 bit add it's value to the resulting int.
        for (i in 0..result.size()) {

            // If the current bit is a 1
            if (result[i]) {

                // Add the bit's value to the resulting integer.
                resultInt += (1 shl i)
            }
        }
        // Return the decimal value of the resulting bitset.
        return resultInt
    }
}