package com.example.artribackend.auth

import com.example.artribackend.model.Role

class RegisterRequest {
    var nickname:String? = null
    var name: String? = null
    var lastname: String? = null
    var password: String? = null
    var age:Long? = null
    var email:String? = null
    var role: Role? = null
}