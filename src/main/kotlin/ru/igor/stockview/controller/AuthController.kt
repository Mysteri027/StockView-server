package ru.igor.stockview.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.igor.stockview.dto.AuthenticationRequest
import ru.igor.stockview.dto.AuthenticationResponse
import ru.igor.stockview.dto.RegisterRequest
import ru.igor.stockview.service.AuthenticationService

@RestController
@RequestMapping("/api/v1/auth")
class AuthController(
    private val authenticationService: AuthenticationService
) {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFoundException(e: NoSuchElementException): ResponseEntity<Map<String, String?>> {
        return ResponseEntity(mapOf("message" to e.message), HttpStatus.NOT_FOUND)
    }

    @PostMapping("/register")
    fun register(
        @RequestBody registerRequest: RegisterRequest
    ): ResponseEntity<AuthenticationResponse> {
        return ResponseEntity.ok(authenticationService.register(registerRequest))
    }

    @PostMapping("/login")
    fun login(
        @RequestBody authenticationRequest: AuthenticationRequest
    ): ResponseEntity<AuthenticationResponse> {
        return ResponseEntity.ok(authenticationService.login(authenticationRequest))
    }
}