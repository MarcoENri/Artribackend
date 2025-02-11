package com.example.artribackend.controller

import com.example.artribackend.model.Member
import com.example.artribackend.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/member")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class MemberController {
    @Autowired
    lateinit var memberService: MemberService

    @GetMapping
    fun list():List<Member>{
        return memberService.list()
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable("id") id:Long):ResponseEntity<*>{
        return ResponseEntity(memberService.findMemberById(id), HttpStatus.ACCEPTED)
    }

    @PostMapping
    fun save(@RequestBody member: Member):ResponseEntity<Member>{
        return ResponseEntity(memberService.save(member), HttpStatus.ACCEPTED)
    }

    @PutMapping
    fun update(@RequestBody member: Member):ResponseEntity<Member>{
        return ResponseEntity(memberService.update(member), HttpStatus.ACCEPTED)
    }



    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable ("id") id:Long):Boolean?{
        return memberService.delete(id)
    }
}