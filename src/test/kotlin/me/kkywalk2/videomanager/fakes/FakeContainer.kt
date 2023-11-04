package me.kkywalk2.videomanager.fakes

import me.kkywalk2.videomanager.members.domains.Member
import me.kkywalk2.videomanager.members.services.MemberService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class FakeContainer {
    private val passwordEncoder = BCryptPasswordEncoder()
    val memberRepository = FakeMemberRepository()
    val memberService = MemberService(memberRepository, passwordEncoder)

    init {
        memberRepository.save(Member(email = "test1@gmail.com", nickName = "test1", password = passwordEncoder.encode("1234")))
    }
}