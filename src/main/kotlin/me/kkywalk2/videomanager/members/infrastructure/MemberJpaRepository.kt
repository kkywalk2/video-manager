package me.kkywalk2.videomanager.members.infrastructure

import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface MemberJpaRepository : JpaRepository<MemberJpaEntity, Long> {

    fun findByEmail(email: String): Optional<MemberJpaEntity>

}