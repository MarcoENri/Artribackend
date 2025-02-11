package com.example.artribackend.repository

import com.example.artribackend.model.Statistics
import org.springframework.data.jpa.repository.JpaRepository

interface StatisticsRepository:JpaRepository<Statistics, Long> {
    fun findById(id: Long?):Statistics?
}