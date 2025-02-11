package com.example.artribackend.controller

import com.example.artribackend.model.Statistics
import com.example.artribackend.service.StatisticsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/statistics")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class StatisticsController {
    @Autowired
    lateinit var statisticsService: StatisticsService

    @GetMapping
    fun list():List<Statistics>{
        return statisticsService.list()
    }

    @GetMapping("/member")
    fun listWithMember ():ResponseEntity<*>{
        return ResponseEntity(statisticsService.listWithMember(), HttpStatus.OK)
    }

    @GetMapping("/member/{id}")
    fun listById(@PathVariable("id") id:Long):ResponseEntity<*>{
        return ResponseEntity(statisticsService.listStatsMember(id), HttpStatus.ACCEPTED)
    }

    @PostMapping
    fun save(@RequestBody statistics: Statistics):ResponseEntity<Statistics>{
        return ResponseEntity(statisticsService.save(statistics), HttpStatus.ACCEPTED)
    }

    @PutMapping
    fun update(@RequestBody statistics: Statistics):ResponseEntity<Statistics>{
        return ResponseEntity(statisticsService.update(statistics), HttpStatus.ACCEPTED)
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable ("id") id:Long):Boolean?{
        return statisticsService.delete(id)
    }
}