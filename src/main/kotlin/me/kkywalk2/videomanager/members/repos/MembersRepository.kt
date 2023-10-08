package me.kkywalk2.videomanager.members.repos;

import me.kkywalk2.videomanager.members.entities.Members
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface MembersRepository : JpaRepository<Members, Long> {

    fun findByEmail(email: String): Optional<Members>

}