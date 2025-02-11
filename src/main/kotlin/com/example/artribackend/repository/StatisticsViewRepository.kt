package com.example.artribackend.repository

import com.example.artribackend.model.Member
import com.example.artribackend.model.StatisticsView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface StatisticsViewRepository:JpaRepository<StatisticsView, Long> {
    @Query("SELECT s FROM StatisticsView s WHERE s.memberId = :id")
    fun findById(@Param("id") id: Long?): List<StatisticsView>

}