package com.example.artribackend.auth

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
@RestController
@CrossOrigin
@RequestMapping("/api/v1/auth")
class AuthenticationController {

    @Autowired
    lateinit var service: AuthenticationService

    @PostMapping("/register")
    fun register(
        @RequestBody request: RegisterRequest
    ): ResponseEntity<AuthenticationResponse?> {
        return try {
            ResponseEntity.ok(service.register(request))
        } catch (e: IllegalArgumentException) {
            ResponseEntity.badRequest().body(AuthenticationResponse("Error: ${e.message}"))
        }
    }


    @PostMapping("/authenticate")
    fun authenticate(
        @RequestBody request: AuthenticationRequest
    ): ResponseEntity<AuthenticationResponse?> {
        return ResponseEntity.ok(service.authenticate(request))
    }
}


