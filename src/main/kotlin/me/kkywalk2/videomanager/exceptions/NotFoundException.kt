package me.kkywalk2.videomanager.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundException: RuntimeException("리소스를 찾을 수 없습니다!")