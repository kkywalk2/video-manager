package me.kkywalk2.videomanager.members.infrastructure

import me.kkywalk2.videomanager.members.domains.Member
import me.kkywalk2.videomanager.members.services.ports.MemberRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
class MemberRepositoryImpl(
    private val memberJpaRepository: MemberJpaRepository,
) : MemberRepository {

    override fun findById(id: Long): Optional<Member> {
        return memberJpaRepository.findById(id).map { it.toDomainEntity() }
    }

    override fun findByEmail(email: String): Optional<Member> {
        return memberJpaRepository.findByEmail(email).map { it.toDomainEntity() }
    }

    override fun save(member: Member): Member {
        return memberJpaRepository.save(MemberJpaEntity.from(member)).toDomainEntity()
    }

}