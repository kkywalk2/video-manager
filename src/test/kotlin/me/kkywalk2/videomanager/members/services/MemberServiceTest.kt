package me.kkywalk2.videomanager.members.services

import me.kkywalk2.videomanager.fakes.FakeContainer
import me.kkywalk2.videomanager.members.domains.CreateMember
import me.kkywalk2.videomanager.members.domains.UpdateMember
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class MemberServiceTest {

    @Test
    fun `멤버를 생성할 수 있다`() {
        val container = FakeContainer()
        val createMember = CreateMember("kkywalk2@gmail.com", "jam9jang", "1234")
        val member = container.memberService.create(createMember)

        Assertions.assertEquals(member.email, "kkywalk2@gmail.com")
        Assertions.assertEquals(member.nickName, "jam9jang")
    }

    @Test
    fun `멤버를 수정할 수 있다`() {
        val container = FakeContainer()
        val updateMember = UpdateMember( "kky")
        val updatedMember = container.memberService.update(1, updateMember)

        Assertions.assertEquals(updatedMember.email, "test1@gmail.com")
        Assertions.assertEquals(updatedMember.nickName, "kky")
    }

}