package me.kkywalk2.videomanager.videos.services

import me.kkywalk2.videomanager.videos.services.ports.VideoConverter
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class VideoConversionTask(
    private val videoConverter: VideoConverter,
) {

    @Scheduled(fixedRate = 1000 * 60)
    fun convertTask() {
        TODO("변환 안된 비디오의 목록을 조회하고 비동기로 변환 실행")
    }

}