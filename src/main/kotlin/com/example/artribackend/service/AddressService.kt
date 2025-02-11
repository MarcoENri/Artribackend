package com.example.artribackend.service

import com.example.artribackend.model.Address
import com.example.artribackend.repository.AddressRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class AddressService {
    @Autowired
    lateinit var addressRepository: AddressRepository

    fun list ():List<Address>{
        return addressRepository.findAll()
    }

    fun findAddressById(id:Long): Optional<Address> {
        return addressRepository.findById(id)
    }
    fun save(address: Address):Address{
        return addressRepository.save(address)
    }
    fun update(address: Address):Address{
        try {
            addressRepository.findById(address.id)
                ?:throw Exception("El id de ${address.id} no existe")
            return addressRepository.save(address)
        }catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun delete(id:Long?):Boolean?{
        addressRepository.findById(id)
            ?:throw Exception("No existe el id")
        addressRepository.deleteById(id!!)
        return true
    }


}