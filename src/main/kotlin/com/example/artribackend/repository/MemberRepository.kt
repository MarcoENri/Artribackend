package com.example.artribackend.repository

import com.example.artribackend.model.Member
import com.example.artribackend.model.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.*

interface MemberRepository : JpaRepository<Member, Long> {
    fun findById(id: Long?): Member?

    fun findByEmail(email: String?): Optional<Member>?

    @Query("SELECT m FROM Member m WHERE m.email = :email")
    fun findIdByEmail(@Param("email") email: String?): Member?

    @Query("SELECT m FROM Member m WHERE m.email = :email")
    fun findRoleByEmail(@Param("email") email: String?): Member?

    // Método para verificar si el correo ya existe
    fun existsByEmail(email: String?): Boolean
}
