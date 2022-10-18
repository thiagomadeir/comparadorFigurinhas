package com.example.comparadordefigurinhas.model

data class User(
    val repeated: List<String>,
    val missing: List<String>
) {
    override fun toString(): String {
        return "User(repeated=$repeated, missing=$missing)"
    }
}
