package com.example.artribackend.model

import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
@Table(name="member")
class Member : UserDetails {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id:Long? = null
    var nickname:String? = null
    var name:String? = null
    var lastname:String? = null
    var age: Long? = null
    var email: String? =null
    @Column(name = "password")
    var passwordMember: String? = null

    @Enumerated(EnumType.STRING)
    var role: Role? = null

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableListOf(SimpleGrantedAuthority(role?.name))
    }

    override fun getPassword(): String? {
        return passwordMember
    }

    override fun getUsername(): String? {
        return nickname
    }
    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true

    }

    override fun isCredentialsNonExpired(): Boolean {
        return true

    }

    override fun isEnabled(): Boolean {
        return true
    }
}