package com.fm.bountysystem.bounty

import com.expediagroup.graphql.spring.operations.Mutation
import com.expediagroup.graphql.spring.operations.Query
import graphql.schema.DataFetcher
import graphql.schema.DataFetchingEnvironment
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.stereotype.Component



data class Company(val id: Int,val name: String)


data class CompanyInput(val id: Int,val name: String)






@Component
class CompanyQuery: Query {
    @Autowired
    private lateinit var resolver: CompanyResolver
    suspend fun allCompany() =  resolver.getAll()
    suspend fun companyById(id: Int) =  resolver.getById(id)
}




@Component
class CompanyMutations : Mutation {
    @Autowired
    private lateinit var resolver: CompanyResolver
    suspend fun createCompany(input: CompanyInput) = resolver.save(input)
}