package ru.igor.stockview.dto

data class AuthenticationRequest(
    val email: String,
    val password: String,
)