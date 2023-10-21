package me.kkywalk2.videomanager.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
class SameNicknameException: RuntimeException("동일한 닉네임으로 수정할 수 없습니다")