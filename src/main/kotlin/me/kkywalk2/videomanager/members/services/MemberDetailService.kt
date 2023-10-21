package me.kkywalk2.videomanager.members.services

import me.kkywalk2.videomanager.members.domains.Member
import me.kkywalk2.videomanager.members.services.ports.MemberRepository
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class MemberDetailService(
    private val memberRepository: MemberRepository,
) : UserDetailsService {
    override fun loadUserByUsername(email: String): UserDetails {
        val member = memberRepository.findByEmail(email)

        return member.map { MemberDetails(it) }.orElseThrow()
    }
}

class MemberDetails(
    private val member: Member
) : UserDetails {
    val id = member.id

    override fun getAuthorities(): Collection<GrantedAuthority> {
        return emptyList()
    }

    override fun getPassword(): String {
        return member.password
    }

    override fun getUsername(): String {
        return member.email
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

}