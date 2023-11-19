package me.kkywalk2.videomanager.videos.controllers

import me.kkywalk2.videomanager.core.StorageManager
import me.kkywalk2.videomanager.members.services.MemberDetails
import me.kkywalk2.videomanager.videos.domains.CreateVideo
import me.kkywalk2.videomanager.videos.services.VideoService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.nio.file.Files

@RestController
@RequestMapping("videos")
class VideoController(
    private val videoService: VideoService,

    // TODO: 제거되야함
    private val storageManager: StorageManager,
) {

    @PostMapping
    fun create(
        @AuthenticationPrincipal memberDetails: MemberDetails,
        @ModelAttribute createVideo: CreateVideo,
    ): VideoDto {
        val video = videoService.create(memberDetails.id, createVideo)
        return VideoDto.from(video)
    }

    //TODO: This code is for function test purposes
    @GetMapping("/hls/{segment}")
    fun getHLSSegment(@PathVariable segment: String): ResponseEntity<ByteArray> {
        val segmentFile = storageManager.readFile(segment)

        if (segmentFile.exists()) {
            val mediaType = MediaType.parseMediaType("application/vnd.apple.mpegurl")
            val content = Files.readAllBytes(segmentFile.toPath())
            return ResponseEntity.ok().contentType(mediaType).body(content)
        }

        return ResponseEntity.notFound().build()
    }

    @GetMapping("/hls/playlist.m3u8")
    fun getHLSPlaylist(): ResponseEntity<ByteArray> {
        val playlistFile = storageManager.readFile("result.m3u8")

        if (playlistFile.exists()) {
            val mediaType = MediaType.parseMediaType("application/vnd.apple.mpegurl")
            val content = Files.readAllBytes(playlistFile.toPath())
            return ResponseEntity.ok().contentType(mediaType).body(content)
        }

        return ResponseEntity.notFound().build()
    }
}