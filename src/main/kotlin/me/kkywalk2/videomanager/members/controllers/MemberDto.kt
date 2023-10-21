package me.kkywalk2.videomanager.members.controllers

import me.kkywalk2.videomanager.members.domains.Member

data class MemberDto(
    val id: Long,
    val email: String,
    val nickName: String,
) {

    companion object {
        fun from(member: Member): MemberDto {
            return MemberDto(
                id = member.id,
                email = member.email,
                nickName = member.nickName,
            )
        }
    }

}
