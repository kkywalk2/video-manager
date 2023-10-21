package me.kkywalk2.videomanager.members.controllers.ports

import me.kkywalk2.videomanager.members.domains.CreateMember
import me.kkywalk2.videomanager.members.domains.Member
import me.kkywalk2.videomanager.members.domains.UpdateMember

interface MemberService {

    fun create(createMember: CreateMember): Member

    fun update(id: Long, updateMember: UpdateMember): Member

}