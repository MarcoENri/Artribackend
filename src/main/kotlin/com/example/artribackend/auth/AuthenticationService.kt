package com.example.artribackend.auth

import com.example.artribackend.config.JwtService
import com.example.artribackend.model.Member
import com.example.artribackend.repository.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
@Service
class AuthenticationService {

    @Autowired
    lateinit var repository: MemberRepository

    @Autowired
    private val passwordEncoder: PasswordEncoder? = null

    @Autowired
    lateinit var jwtService: JwtService

    @Autowired
    lateinit var authenticationManager: AuthenticationManager

    fun register(request: RegisterRequest): AuthenticationResponse? {
        if (repository.existsByEmail(request.email)) {
            throw IllegalArgumentException("El correo electrónico ya está registrado.")
        }

        val member = Member().apply {
            name = request.name
            lastname = request.lastname
            age = request.age
            email = request.email
            passwordMember = passwordEncoder?.encode(request.password)
            role = request.role
        }

        repository.save(member)

        val jwtToken = jwtService.generateToken(member)

        return AuthenticationResponse(token = jwtToken)
    }

    fun authenticate(request: AuthenticationRequest): AuthenticationResponse? {
        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(
                request.email,
                request.password
            )
        )

        val user = repository.findByEmail(request.email)?.orElseThrow()
        val idMember = repository.findIdByEmail(request.email)?.id
        val memberName = repository.findIdByEmail(request.email)?.email
        val roleMember = repository.findIdByEmail(request.email)?.role

        val jwtToken: String? = user?.let { jwtService.generateToken(it) }

        return AuthenticationResponse(
            token = jwtToken,
            username = memberName,
            memberRole = roleMember?.name, // Convierte Role? a String?
            userId = idMember
        )

    }

}



