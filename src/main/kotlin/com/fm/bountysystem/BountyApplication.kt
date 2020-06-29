package com.fm.bountysystem

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BountyApplication

fun main(args: Array<String>) {
	runApplication<BountyApplication>(*args)
}
