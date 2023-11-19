package me.kkywalk2.videomanager.videos.infrastructure

import org.springframework.data.jpa.repository.JpaRepository

interface VideoJpaRepository : JpaRepository<VideoJpaEntity, Long> {
}