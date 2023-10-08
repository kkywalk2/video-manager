package me.kkywalk2.videomanager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication
class VideoManagerApplication

fun main(args: Array<String>) {
    runApplication<VideoManagerApplication>(*args)
}
