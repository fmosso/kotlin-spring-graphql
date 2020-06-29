package com.fm.bountysystem.bounty

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*




@Component
class CompanyResolver{

    @Autowired
    lateinit var companyRepository: CompanyRepository

    suspend fun save(companyInput: CompanyInput): Company {
       val result = companyRepository.save(CompanyDB(companyInput.id, companyInput.name) )
       return  Company(result.id,result.name)
    }

    suspend fun getAll(): List<Company> {
        return companyRepository.findAll().map { Company(it.id,it.name) }
    }

    suspend fun getById(id: Int): Company? {
        val result = companyRepository.findById(id)
        println("Resultado de obtener Id $id y resultado $result")
        return result.map { Company(it.id,it.name) }.orElse(null)
    }
}