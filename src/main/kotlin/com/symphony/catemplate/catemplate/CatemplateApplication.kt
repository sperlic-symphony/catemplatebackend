package com.symphony.catemplate.catemplate

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("com.symphony.catemplate")
class CatemplateApplication

fun main(args: Array<String>) {
	runApplication<CatemplateApplication>(*args)
}