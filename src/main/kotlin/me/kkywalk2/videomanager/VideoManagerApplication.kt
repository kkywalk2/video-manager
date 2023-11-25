package me.kkywalk2.videomanager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class VideoManagerApplication

fun main(args: Array<String>) {
    runApplication<VideoManagerApplication>(*args)
}
