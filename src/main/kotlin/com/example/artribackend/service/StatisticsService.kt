package com.example.artribackend.service

import com.example.artribackend.model.Statistics
import com.example.artribackend.model.StatisticsView
import com.example.artribackend.repository.StatisticsRepository
import com.example.artribackend.repository.StatisticsViewRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class StatisticsService {
    @Autowired
    lateinit var statisticsRepository: StatisticsRepository

    @Autowired
    lateinit var statisticsViewRepository: StatisticsViewRepository

    fun list ():List<Statistics>{
        return statisticsRepository.findAll()
    }
    fun listStatsMember(id: Long?): List<StatisticsView> {
        return statisticsViewRepository.findById(id)
    }


    fun listWithMember(): List<StatisticsView> {
        return statisticsViewRepository.findAll()
    }

    fun save(statistics: Statistics):Statistics{
        return statisticsRepository.save(statistics)
    }
    fun update(statistics: Statistics):Statistics{
        try {
            statisticsRepository.findById(statistics.id)
                ?:throw Exception("El id de ${statistics.id} no existe")
            return statisticsRepository.save(statistics)
        }catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun delete(id:Long?):Boolean?{
        statisticsRepository.findById(id)
            ?:throw Exception("No existe el id")
        statisticsRepository.deleteById(id!!)
        return true
    }


}