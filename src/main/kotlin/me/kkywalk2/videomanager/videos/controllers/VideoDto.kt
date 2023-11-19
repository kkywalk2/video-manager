package me.kkywalk2.videomanager.videos.controllers

import me.kkywalk2.videomanager.videos.domains.Video

data class VideoDto(
    val id: Long = 0,
    val path: String,
    val title: String,
    val conversionComplete: Boolean,
) {

    companion object {
        fun from(video: Video): VideoDto {
            return VideoDto(
                id = video.id,
                path = video.path,
                title = video.title,
                conversionComplete = video.conversionComplete,
            )
        }
    }

}
