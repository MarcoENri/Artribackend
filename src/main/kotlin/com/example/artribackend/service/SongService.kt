package com.example.artribackend.service

import com.example.artribackend.model.Song
import com.example.artribackend.repository.SongRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class SongService {
    @Autowired
    lateinit var songRepository: SongRepository

    fun list ():List<Song>{
        return songRepository.findAll()
    }

    fun findSongById(id:Long): Optional<Song> {
        return songRepository.findById(id)
    }
    fun save(song: Song):Song{
        return songRepository.save(song)
    }
    fun update(song: Song):Song{
        try {
            songRepository.findById(song.id)
                ?:throw Exception("El id de ${song.id} no existe")
            return songRepository.save(song)
        }catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun delete(id:Long?):Boolean?{
        songRepository.findById(id)
            ?:throw Exception("No existe el id")
        songRepository.deleteById(id!!)
        return true
    }


}