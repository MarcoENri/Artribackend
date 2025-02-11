package com.example.artribackend.repository

import com.example.artribackend.model.Address
import org.springframework.data.jpa.repository.JpaRepository

interface AddressRepository:JpaRepository<Address, Long> {
    fun findById(id: Long?):Address?
}