package com.example.artribackend.service

import com.example.artribackend.model.Member
import com.example.artribackend.repository.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class MemberService {

    @Autowired
    lateinit var memberRepository: MemberRepository

    @Autowired
    lateinit var passwordEncoder: BCryptPasswordEncoder // Inyección de dependencias

    fun list(): List<Member> {
        return memberRepository.findAll()
    }

    fun findMemberById(id: Long): Optional<Member> {
        return memberRepository.findById(id)
    }

    fun save(member: Member): Member {
        // Encriptar la contraseña antes de guardar un nuevo miembro
        member.passwordMember = passwordEncoder.encode(member.passwordMember)
        return memberRepository.save(member)
    }

    fun update(member: Member): Member {
        return memberRepository.findById(member.id ?: throw Exception("ID no puede ser nulo")).map {
            // Solo actualizar campos necesarios, encriptando la contraseña si es necesario
            it.apply {
                name = member.name
                lastname = member.lastname
                age = member.age
                email = member.email
                role = member.role
                passwordMember = member.passwordMember?.let { pwd -> passwordEncoder.encode(pwd) } ?: it.passwordMember
            }
        }.orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "El id de ${member.id} no existe") }
            .let { memberRepository.save(it) }
    }

    fun delete(id: Long?): Boolean {
        val member = memberRepository.findById(id ?: throw Exception("ID no puede ser nulo"))
            .orElseThrow { Exception("No existe el id $id") }
        memberRepository.delete(member)
        return true
    }

    fun changePassword(memberId: Long, newPassword: String): Member {
        val member = memberRepository.findById(memberId).orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario con ID $memberId no fue encontrado")
        }
        // Encriptar la nueva contraseña antes de guardarla
        member.passwordMember = passwordEncoder.encode(newPassword)
        return memberRepository.save(member)
    }
}
