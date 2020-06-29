package com.fm.bountysystem.bounty

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*


fun toBountyDB(input: BountyInput, id: String ): BountyDB = BountyDB(id, input.name, input.description, input.difficulty, input.link, input.contact, input.technologies, input.companyID)

suspend fun toBounty(result: BountyDB, resolver: CompanyResolver ): Bounty =
    Bounty(result.id, result.name, result.description, result.difficulty, result.link, result.contact, result.technologies, result.company ,resolver)




@Component
class BountyResolver{

    @Autowired
    lateinit var bountyRepository: BountyRepository

    @Autowired
    lateinit var resolver: CompanyResolver

    suspend fun save(bountyInput: BountyInput): Bounty {
       return toBounty(bountyRepository.save(toBountyDB(bountyInput, UUID.randomUUID().toString())), resolver)
    }

    suspend fun getAll(): List<Bounty> {
        return bountyRepository.findAll().map {  toBounty(it, resolver) }
    }
}