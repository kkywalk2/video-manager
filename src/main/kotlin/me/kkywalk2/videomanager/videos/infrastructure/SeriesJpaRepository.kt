package me.kkywalk2.videomanager.videos.infrastructure

import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface SeriesJpaRepository : JpaRepository<SeriesJpaEntity, Long> {

    fun findByName(name: String): Optional<SeriesJpaEntity>

}
