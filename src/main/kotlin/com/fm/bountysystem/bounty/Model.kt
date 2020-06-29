package com.fm.bountysystem.bounty

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

// type on db

@Document(collection = "bounty")
data class BountyDB(@Id val id: String,
                  val name: String,
                  val description: String,
                  val difficulty: Int,
                  val link : String,
                  val contact: String,
                  val technologies: List<String>,
                  val company : Int)