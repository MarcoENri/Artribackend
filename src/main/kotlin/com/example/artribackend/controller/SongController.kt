package com.example.artribackend.controller

import com.example.artribackend.model.Song
import com.example.artribackend.service.SongService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/song")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class SongController {
    @Autowired
    lateinit var songService: SongService

    @GetMapping
    fun list():List<Song>{
        return songService.list()
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable("id") id:Long):ResponseEntity<*>{
        return ResponseEntity(songService.findSongById(id), HttpStatus.ACCEPTED)
    }

    @PostMapping
    fun save(@RequestBody song: Song):ResponseEntity<Song>{
        return ResponseEntity(songService.save(song), HttpStatus.ACCEPTED)
    }

    @PutMapping
    fun update(@RequestBody song: Song):ResponseEntity<Song>{
        return ResponseEntity(songService.update(song), HttpStatus.ACCEPTED)
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable ("id") id:Long):Boolean?{
        return songService.delete(id)
    }
}