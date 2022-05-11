package br.com.gustavodiniz.forum

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@EnableCaching
@SpringBootApplication
class ForumApplication

fun main(args: Array<String>) {
	runApplication<ForumApplication>(*args)
}
