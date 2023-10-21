package me.kkywalk2.videomanager.members.domains

data class Member(
    val id: Long = 0,
    val email: String,
    val nickName: String,
    val password: String,
) {

    fun update(updateMember: UpdateMember): Member {
        return this.copy(nickName = updateMember.nickName)
    }

    companion object {
        fun create(createMember: CreateMember): Member {
            return Member(
                email = createMember.email,
                nickName = createMember.nickName,
                password = createMember.password
            )
        }
    }

}
