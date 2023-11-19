package me.kkywalk2.videomanager.videos.services

import me.kkywalk2.videomanager.core.StorageManager
import me.kkywalk2.videomanager.exceptions.NotFoundException
import me.kkywalk2.videomanager.videos.domains.CreateVideo
import me.kkywalk2.videomanager.videos.domains.Video
import me.kkywalk2.videomanager.videos.services.ports.SeriesRepository
import me.kkywalk2.videomanager.videos.services.ports.VideoRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class VideoService(
    private val storageManager: StorageManager,
    private val seriesRepository: SeriesRepository,
    private val videoRepository: VideoRepository,
) {

    fun create(memberId: Long, createVideo: CreateVideo): Video {
        val series = seriesRepository
            .findById(createVideo.seriesId)
            .filter { it.memberId == memberId }
            .orElseThrow { NotFoundException() }

        val video = Video.create(memberId, createVideo)

        // TODO: group 명이 존재하지 않으면 에러가 발생해야함
        val modifiedSeries =
            series.copy(groups = series.groups.map { if (it.name == createVideo.groupName) it.copy(videoIds = it.videoIds + video.id) else it })

        storageManager.uploadFile(video.path, createVideo.videoFile.bytes)

        seriesRepository.save(modifiedSeries)
        return videoRepository.save(video)
    }

}