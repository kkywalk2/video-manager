package me.kkywalk2.videomanager.videos.domains

data class Video(
    val id: Long = 0,
    val memberId: Long,
    val path: String,
    val title: String,
    val conversionResult: String? = null,
    val conversionComplete: Boolean,
) {

    companion object {
        fun create(memberId: Long, createVideo: CreateVideo): Video {
            return Video(
                memberId = memberId,
                path = "${createVideo.seriesId}/${createVideo.groupName}",
                title = createVideo.title,
                conversionComplete = false,
            )
        }
    }

}
