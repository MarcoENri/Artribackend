package com.example.artribackend.auth

data class AuthenticationResponse(
    val token: String? = null,
    val username: String? = null,
    val memberRole: String? = null,
    val userId: Long? = null,
    val errorMessage: String? = null
) {
    // Constructor secundario llamando al constructor primario
    constructor(errorMessage: String) : this(null, null, null, null, errorMessage)
}

