package me.kkywalk2.videomanager.videos.infrastructure

import me.kkywalk2.videomanager.videos.services.ports.VideoConverter
import net.bramp.ffmpeg.FFmpeg
import net.bramp.ffmpeg.FFprobe
import org.springframework.stereotype.Component

@Component
class VideoConverterImpl(
    private val ffMpeg: FFmpeg,
    private val ffProbe: FFprobe,
): VideoConverter {

    override fun convert(): String {
        TODO("Not yet implemented")
    }

}