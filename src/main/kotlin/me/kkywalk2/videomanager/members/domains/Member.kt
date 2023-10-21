package me.kkywalk2.videomanager.members.domains

import me.kkywalk2.videomanager.exceptions.SameNicknameException
import org.springframework.security.crypto.password.PasswordEncoder

data class Member(
    val id: Long = 0,
    val email: String,
    val nickName: String,
    val password: String,
) {

    fun update(updateMember: UpdateMember): Member {
        if(this.nickName == updateMember.nickName) throw SameNicknameException()
        return this.copy(nickName = updateMember.nickName)
    }

    companion object {
        fun create(createMember: CreateMember, passwordEncoder: PasswordEncoder): Member {
            return Member(
                email = createMember.email,
                nickName = createMember.nickName,
                password = passwordEncoder.encode(createMember.password),
            )
        }
    }

}
