package me.kkywalk2.videomanager.members.domains

import me.kkywalk2.videomanager.exceptions.SameNicknameException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class MemberTest {

    @Test
    fun `멤버를 생성할 수 있다`() {
        val createMember = CreateMember(email = "kkywalk2@gmail.com", nickName = "kkywalk2", password = "1234")
        val passwordEncoder = BCryptPasswordEncoder()
        val newMember = Member.create(createMember, passwordEncoder)

        Assertions.assertEquals(newMember.email, "kkywalk2@gmail.com")
        Assertions.assertTrue(passwordEncoder.matches("1234", newMember.password))
        Assertions.assertEquals(newMember.nickName, "kkywalk2")
    }

    @Test
    fun `멤버를 수정할 수 있다`() {
        val member = Member(email = "kkywalk2@gmail.com", nickName =  "kkywalk2", password =  "1234")
        val updateMember = UpdateMember("jamgujang")
        val updatedMember = member.update(updateMember)

        Assertions.assertEquals(updatedMember.email, "kkywalk2@gmail.com")
        Assertions.assertEquals(updatedMember.nickName, "jamgujang")
    }

    @Test
    fun `동일한 닉네임으론 멤버를 수정할 수 없다`() {
        val member = Member(email = "kkywalk2@gmail.com", nickName =  "kkywalk2", password =  "1234")
        val updateMember = UpdateMember("kkywalk2")

        Assertions.assertThrows(SameNicknameException::class.java) {
            member.update(updateMember)
        }
    }

}