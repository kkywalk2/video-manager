package me.kkywalk2.videomanager.members.infrastructure

import me.kkywalk2.videomanager.members.domains.Member
import javax.persistence.*

@Entity
@Table(name = "members")
class MemberJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,

    val email: String,

    val nickName: String,

    val password: String,
) {

    fun toDomainEntity(): Member {
        return Member(id, email, nickName, password)
    }

    companion object {
        fun from(member: Member): MemberJpaEntity {
            return MemberJpaEntity(member.id, member.email, member.nickName, member.password)
        }
    }

}