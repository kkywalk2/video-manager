package me.kkywalk2.videomanager.videos.domains

data class Video(
    val id: Long = 0,
    val memberId: Long,
    val path: String,
    val title: String,
    val conversionComplete: Boolean,

    // TODO: video 관련 meta 정보 추가
) {

    companion object {
        fun create(memberId: Long, createVideo: CreateVideo): Video {
            return Video(
                memberId = memberId,
                path = "${createVideo.seriesId}/${createVideo.groupName}/${createVideo.title}",
                title = createVideo.title,
                conversionComplete = false,
            )
        }
    }

}
