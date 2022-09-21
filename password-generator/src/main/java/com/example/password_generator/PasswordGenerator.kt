package com.example.password_generator

const val SYMBOLS = 1
const val NUMBERS = 2
const val UPPERCASE = 3
const val LOWERCASE = 4

class PasswordGenerator {
    fun generatePassword(): String {
        var password = ""
        val length = 8
        var symbols = false
        var uppercase = false
        var lowercase = false
        var numbers = false
        for (j in 0 until length) {
            if (!symbols) {
                password += getRandom(SYMBOLS)
                symbols = true
                continue
            }
            if (!uppercase) {
                password += getRandom(UPPERCASE)
                uppercase = true
                continue
            }
            if (!lowercase) {
                password += getRandom(LOWERCASE)
                lowercase = true
                continue
            }
            if (!numbers) {
                password += getRandom(NUMBERS)
                numbers = true
                continue
            }
            password += getRandom((0..4).random())
        }
        return shuffle(password)
    }

    private fun shuffle(empty: String): String {
        var result = ""
        var s = empty
        while (s.isNotEmpty()) {
            val randomIndex = (s.indices).random()
            result += s[randomIndex]
            val a = try {
                s.substring(0, randomIndex)
            } catch (e: java.lang.Exception) {
                ""
            }
            val b = try {
                s.substring(randomIndex + 1)
            } catch (e: java.lang.Exception) {
                ""
            }
            s = a + b
        }
        return result
    }

    private fun getRandom(type: Int): String {
        val symbols = "!@##$%^&*()"
        val lowercase = "qwertyuiopasdfghjklzxcvbnm"
        val uppercase = "QWERTYUIOPASDFGHJKLZXCVBNM"
        val numbers = "0123456789"
        if (type == SYMBOLS) return symbols[(symbols.indices).random()].toString()
        if (type == LOWERCASE) return lowercase[(lowercase.indices).random()].toString()
        if (type == UPPERCASE) return uppercase[(uppercase.indices).random()].toString()
        if (type == NUMBERS) return numbers[(numbers.indices).random()].toString()
        return ""
    }

}