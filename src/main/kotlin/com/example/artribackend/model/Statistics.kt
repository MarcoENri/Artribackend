package com.example.artribackend.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.Date

@Entity
@Table(name="statistics")
class Statistics {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id:Long? = null
    var date:Date? = null
    var score:Long? = null
    @Column(name="song_id")
    var songId:Long? = null
    @Column(name="member_id")
    var memberId:Long? = null
}