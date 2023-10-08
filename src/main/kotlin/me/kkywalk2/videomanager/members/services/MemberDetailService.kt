package me.kkywalk2.videomanager.members.services

import me.kkywalk2.videomanager.members.entities.Members
import me.kkywalk2.videomanager.members.repos.MembersRepository
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class MemberDetailService(
    private val membersRepository: MembersRepository,
): UserDetailsService {
    override fun loadUserByUsername(email: String): UserDetails {
        val member = membersRepository.findByEmail(email)

        return member.map { MemberDetails(it) }.orElseThrow()
    }
}

class MemberDetails(
    private val member: Members
): UserDetails {
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