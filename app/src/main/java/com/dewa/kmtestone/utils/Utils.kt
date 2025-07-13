package com.dewa.kmtestone.utils

object Utils {
    fun isPalindrome(text: String): Boolean {
        val cleaned = text.lowercase().filter { it.isLetterOrDigit() }
        return cleaned == cleaned.reversed()
    }
}