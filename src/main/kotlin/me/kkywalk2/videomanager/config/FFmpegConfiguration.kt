package me.kkywalk2.videomanager.config

import net.bramp.ffmpeg.FFmpeg
import net.bramp.ffmpeg.FFprobe
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class FFmpegConfiguration {

    @Bean
    fun ffMpeg(): FFmpeg {
        return FFmpeg("C:\\bin\\ffmpeg")
    }

    @Bean
    fun ffProbe(): FFprobe {
        return FFprobe("C:\\bin\\ffprobe")
    }

}