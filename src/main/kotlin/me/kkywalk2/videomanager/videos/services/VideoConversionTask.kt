package me.kkywalk2.videomanager.videos.services

import me.kkywalk2.videomanager.videos.services.ports.VideoConverter
import me.kkywalk2.videomanager.videos.services.ports.VideoRepository
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class VideoConversionTask(
    private val videoRepository: VideoRepository,
    private val videoConverter: VideoConverter,
) {

    @Scheduled(fixedRate = 1000 * 60 * 60)
    fun convertTask() {
        videoRepository
            .getByConversionCompleteIsFalse()
            .map { videoConverter.convert(it.path, it.title) }
    }

}