package me.kkywalk2.videomanager.videos.services.ports

import me.kkywalk2.videomanager.videos.domains.Series
import java.util.Optional

interface SeriesRepository {

    fun save(series: Series): Series

    fun findByMemberId(memberId: Long): List<Series>

    fun findById(seriesId: Long): Optional<Series>

}