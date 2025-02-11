package com.example.artribackend.service

import com.example.artribackend.model.Member
import com.example.artribackend.repository.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class MemberService {
    @Autowired
    lateinit var memberRepository: MemberRepository

    fun list ():List<Member>{
        return memberRepository.findAll()
    }

    fun findMemberById(id:Long): Optional<Member> {
        return memberRepository.findById(id)
    }
    fun save(member: Member):Member{
        return memberRepository.save(member)
    }
    fun update(member: Member):Member{
        try {
            memberRepository.findById(member.id)
                ?:throw Exception("El id de ${member.id} no existe")
            return memberRepository.save(member)
        }catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun delete(id:Long?):Boolean?{
        memberRepository.findById(id)
            ?:throw Exception("No existe el id")
        memberRepository.deleteById(id!!)
        return true
    }


}