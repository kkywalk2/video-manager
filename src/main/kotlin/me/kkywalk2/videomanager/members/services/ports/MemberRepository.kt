package me.kkywalk2.videomanager.members.services.ports

import me.kkywalk2.videomanager.members.domains.Member
import java.util.*

interface MemberRepository {

    fun findById(id: Long): Optional<Member>

    fun findByEmail(email: String): Optional<Member>

    fun save(member: Member): Member

}
