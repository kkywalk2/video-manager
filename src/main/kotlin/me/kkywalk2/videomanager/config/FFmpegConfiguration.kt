package me.kkywalk2.videomanager.config

import net.bramp.ffmpeg.FFmpeg
import net.bramp.ffmpeg.FFprobe
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class FFmpegConfiguration(
    @Value("\${video-manager.ffmpeg-path}") private val ffmpegPath: String,
    @Value("\${video-manager.ffprobe-path}") private val ffprobePath: String,
) {

    @Bean
    fun ffMpeg(): FFmpeg {
        return FFmpeg(ffmpegPath)
    }

    @Bean
    fun ffProbe(): FFprobe {
        return FFprobe(ffprobePath)
    }

}