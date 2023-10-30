package me.kkywalk2.videomanager.videos.services

import me.kkywalk2.videomanager.exceptions.NotFoundException
import me.kkywalk2.videomanager.videos.domains.CreateSeries
import me.kkywalk2.videomanager.videos.domains.Series
import me.kkywalk2.videomanager.videos.domains.UpdateSeries
import me.kkywalk2.videomanager.videos.services.ports.SeriesRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class SeriesService(
    private val seriesRepository: SeriesRepository,
) {

    fun create(memberId: Long, createSeries: CreateSeries): Series {
        return seriesRepository.save(Series.create(memberId, createSeries))
    }

    fun update(memberId: Long, seriesId: Long, updateSeries: UpdateSeries): Series {
        return seriesRepository
            .findById(seriesId)
            .filter { it.memberId == memberId }
            .map { seriesRepository.save(it.update(updateSeries)) }
            .orElseThrow { NotFoundException() }
    }

}