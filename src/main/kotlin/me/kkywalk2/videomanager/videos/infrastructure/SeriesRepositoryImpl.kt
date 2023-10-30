package me.kkywalk2.videomanager.videos.infrastructure

import me.kkywalk2.videomanager.videos.domains.Group
import me.kkywalk2.videomanager.videos.domains.Series
import me.kkywalk2.videomanager.videos.services.ports.SeriesRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class SeriesRepositoryImpl(
    private val seriesJpaRepository: SeriesJpaRepository,
) : SeriesRepository {

    override fun findByMemberId(memberId: Long): List<Series> {
        return seriesJpaRepository.findByMemberId(memberId).map { it.toDomainEntity() }
    }

    override fun findById(seriesId: Long): Optional<Series> {
        return seriesJpaRepository.findById(seriesId).map { it.toDomainEntity() }
    }

    override fun save(series: Series): Series {
        return seriesJpaRepository.save(series.toJpaEntity()).toDomainEntity()
    }

    private fun Series.toJpaEntity(): SeriesJpaEntity {
        return SeriesJpaEntity(
            id = this.id,
            memberId = this.memberId,
            name = this.name,
            groups = this.groups.map { it.toJpaAttribute() },
        )
    }

    private fun Group.toJpaAttribute(): GroupAttribute {
        return GroupAttribute(
            name = this.name,
            videoIds = this.videoIds,
        )
    }

    private fun SeriesJpaEntity.toDomainEntity(): Series {
        return Series(
            id = this.id,
            memberId = this.memberId,
            name = this.name,
            groups = this.groups.map { it.toDomainEntity() },
        )
    }

    private fun GroupAttribute.toDomainEntity(): Group {
        return Group(
            name = this.name,
            videoIds = this.videoIds,
        )
    }

}