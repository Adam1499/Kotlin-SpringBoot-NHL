package com.adam1499.kotlin_springboot_nhl

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinNhlApplication

fun main(args: Array<String>) {
	runApplication<KotlinNhlApplication>(*args)
}
