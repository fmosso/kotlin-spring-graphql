package com.fm.bountysystem.bounty

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

// type on db

@Document(collection = "company")
data class CompanyDB(@Id val id: Int,val name: String)
