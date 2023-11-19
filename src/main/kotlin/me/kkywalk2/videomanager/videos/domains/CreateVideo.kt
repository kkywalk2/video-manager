package me.kkywalk2.videomanager.videos.domains

import org.springframework.web.multipart.MultipartFile

data class CreateVideo(
    val title: String,
    val seriesId: Long,
    val groupName: String,
    val videoFile: MultipartFile,
)
