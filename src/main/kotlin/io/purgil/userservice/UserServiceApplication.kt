package io.purgil.userservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing

@SpringBootApplication
//@ComponentScan(basePackages = ["io.purgil.userservice"])
//@ComponentScan(basePackages = ["io.purgil.userservice", "io.purgil.sharedlib"])
class UserServiceApplication

fun main(args: Array<String>) {
	runApplication<UserServiceApplication>(*args)
}
