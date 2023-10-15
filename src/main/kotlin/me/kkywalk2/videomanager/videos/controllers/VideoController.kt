package me.kkywalk2.videomanager.videos.controllers

import me.kkywalk2.videomanager.core.StorageManager
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.nio.file.Files

@Controller
class VideoController(
    private val storageManager: StorageManager,
) {

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