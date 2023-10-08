package me.kkywalk2.videomanager.auth.controllers

import me.kkywalk2.videomanager.auth.models.LoginRequest
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.context.HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpSession


@RestController
class AuthController(
    private val authenticationManager: AuthenticationManager,
) {

    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest, request: HttpServletRequest) {
        val authReq = UsernamePasswordAuthenticationToken(loginRequest.email, loginRequest.password)
        val auth = authenticationManager.authenticate(authReq)

        val sc = SecurityContextHolder.getContext()
        sc.authentication = auth
        val session: HttpSession = request.getSession(true)
        session.setAttribute(SPRING_SECURITY_CONTEXT_KEY, sc)
    }

}