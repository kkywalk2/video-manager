package me.kkywalk2.videomanager.members.services

import me.kkywalk2.videomanager.members.controllers.ports.MemberService
import me.kkywalk2.videomanager.members.domains.CreateMember
import me.kkywalk2.videomanager.members.domains.Member
import me.kkywalk2.videomanager.members.domains.UpdateMember
import me.kkywalk2.videomanager.members.services.ports.MemberRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityNotFoundException

@Service
@Transactional
class MemberServiceImpl(
    private val memberRepository: MemberRepository,
    private val passwordEncoder: PasswordEncoder,
): MemberService {

    override fun create(createMember: CreateMember): Member {
        val member = Member.create(createMember, passwordEncoder)
        return memberRepository.save(member)
    }

    override fun update(id: Long, updateMember: UpdateMember): Member {
        val member = memberRepository.findById(id).orElseThrow { EntityNotFoundException() }
        return memberRepository.save(member.update(updateMember))
    }

}