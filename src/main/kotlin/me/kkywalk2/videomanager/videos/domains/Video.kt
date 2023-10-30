package me.kkywalk2.videomanager.videos.domains

data class Video(
    val id: Long = 0,
    val memberId: Long,
    val path: String,
)
