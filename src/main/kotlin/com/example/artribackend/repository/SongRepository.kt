package com.example.artribackend.repository

import com.example.artribackend.model.Song
import org.springframework.data.jpa.repository.JpaRepository

interface SongRepository:JpaRepository<Song, Long> {
    fun findById(id: Long?):Song?
}