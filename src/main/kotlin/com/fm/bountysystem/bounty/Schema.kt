package com.fm.bountysystem.bounty

import com.expediagroup.graphql.annotations.GraphQLIgnore
import com.expediagroup.graphql.spring.operations.Mutation
import com.expediagroup.graphql.spring.operations.Query

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component




class Bounty(val id: String,
                  val name: String,
                  val description: String,
                  val difficulty: Int,
                  val link : String,
                  val contact: String,
                  val technologies: List<String>,
                  private val companyID: Int,
                  @GraphQLIgnore val resolver: CompanyResolver
) {

    suspend fun company(): Company {
        println("quien me llama? $companyID")
        return resolver.getById(companyID) !!
    }
}

data class BountyInput(val name: String,
                  val description: String,
                  val difficulty: Int,
                  val link : String,
                  val contact: String,
                  val technologies: List<String>,
                  val companyID: Int
)


@Component
class BountyQuery: Query {
    @Autowired
    private lateinit var resolver: BountyResolver
    suspend fun allBounty() =  resolver.getAll()
}


@Component
class BountyMutations : Mutation {
    @Autowired
    private lateinit var resolver: BountyResolver
    suspend fun postBounty(input: BountyInput) : Bounty {
        return resolver.save(input)}
}


