package me.kkywalk2.videomanager.videos.services.ports

import me.kkywalk2.videomanager.videos.domains.Video

interface VideoRepository {

    fun save(video: Video): Video

    fun getByConversionCompleteIsFalse(): List<Video>

}