package ru.igor.stockview.dto.auth

data class RegisterRequest(
    val email: String,
    val password: String,
)
