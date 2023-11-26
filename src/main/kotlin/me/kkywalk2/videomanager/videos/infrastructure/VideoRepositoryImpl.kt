package me.kkywalk2.videomanager.videos.infrastructure

import me.kkywalk2.videomanager.videos.domains.Video
import me.kkywalk2.videomanager.videos.services.ports.VideoRepository
import org.springframework.stereotype.Repository

@Repository
class VideoRepositoryImpl(
    private val videoJpaRepository: VideoJpaRepository,
) : VideoRepository {

    override fun save(video: Video): Video {
        return videoJpaRepository.save(video.toJpaEntity()).toDomainEntity()
    }

    override fun getByConversionCompleteIsFalse(): List<Video> {
        return videoJpaRepository.getByConversionComplete(false).map { it.toDomainEntity() }
    }

    private fun Video.toJpaEntity(): VideoJpaEntity {
        return VideoJpaEntity(
            id = id,
            memberId = memberId,
            path = path,
            title = title,
            conversionComplete = conversionComplete,
        )
    }

    private fun VideoJpaEntity.toDomainEntity(): Video {
        return Video(
            id = id,
            memberId = memberId,
            path = path,
            title = title,
            conversionComplete = conversionComplete,
        )
    }

}
