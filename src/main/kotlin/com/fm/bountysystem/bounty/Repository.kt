package com.fm.bountysystem.bounty

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface BountyRepository : MongoRepository<BountyDB, String>