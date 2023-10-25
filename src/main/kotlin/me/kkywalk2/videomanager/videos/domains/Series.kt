package me.kkywalk2.videomanager.videos.domains

data class Series(
    val id: Long = 0,
    val name: String,
    val groups: List<Group>,
)
