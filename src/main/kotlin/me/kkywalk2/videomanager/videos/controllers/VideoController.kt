package me.kkywalk2.videomanager.videos.controllers

import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.io.File
import java.nio.file.Files

@Controller
class VideoController {

    //TODO: This code is for function test purposes
    @GetMapping("/hls/{segment}")
    fun getHLSSegment(@PathVariable segment: String): ResponseEntity<ByteArray> {
        val segmentPath = "./test/$segment"  // Path to your HLS segments
        val segmentFile = File(segmentPath)

        if (segmentFile.exists()) {
            val mediaType = MediaType.parseMediaType("application/vnd.apple.mpegurl")
            val content = Files.readAllBytes(segmentFile.toPath())
            return ResponseEntity.ok().contentType(mediaType).body(content)
        }

        return ResponseEntity.notFound().build()
    }

    @GetMapping("/hls/playlist.m3u8")
    fun getHLSPlaylist(): ResponseEntity<ByteArray> {
        val playlistPath = "./test/result.m3u8"  // Path to your HLS playlist file
        val playlistFile = File(playlistPath)

        if (playlistFile.exists()) {
            val mediaType = MediaType.parseMediaType("application/vnd.apple.mpegurl")
            val content = Files.readAllBytes(playlistFile.toPath())
            return ResponseEntity.ok().contentType(mediaType).body(content)
        }

        return ResponseEntity.notFound().build()
    }
}