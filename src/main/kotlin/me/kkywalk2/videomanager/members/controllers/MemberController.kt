package me.kkywalk2.videomanager.members.controllers

import me.kkywalk2.videomanager.members.controllers.ports.MemberService
import me.kkywalk2.videomanager.members.domains.CreateMember
import me.kkywalk2.videomanager.members.domains.UpdateMember
import me.kkywalk2.videomanager.members.services.MemberDetails
import org.springframework.http.HttpStatus
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/members")
class MemberController(
    private val memberService: MemberService,
) {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    fun create(@RequestBody createMember: CreateMember): MemberDto {
        val member = memberService.create(createMember)
        return MemberDto.from(member)
    }

    @PutMapping
    fun update(
        @AuthenticationPrincipal memberDetails: MemberDetails,
        @RequestBody updateMember: UpdateMember
    ): MemberDto {
        val member = memberService.update(memberDetails.id, updateMember)
        return MemberDto.from(member)
    }

}