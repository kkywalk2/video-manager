package me.kkywalk2.videomanager.videos.services.ports

interface VideoConverter {

    fun convert(path: String, title: String): String

}
