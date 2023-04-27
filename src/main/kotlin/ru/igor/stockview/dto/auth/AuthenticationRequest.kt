package ru.igor.stockview.dto.auth

data class AuthenticationRequest(
    val email: String,
    val password: String,
)