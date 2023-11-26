package me.kkywalk2.videomanager.videos.infrastructure

import me.kkywalk2.videomanager.videos.services.ports.VideoConverter
import net.bramp.ffmpeg.FFmpeg
import net.bramp.ffmpeg.FFmpegExecutor
import net.bramp.ffmpeg.FFprobe
import net.bramp.ffmpeg.builder.FFmpegBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.io.File

@Component
class VideoConverterImpl(
    private val ffMpeg: FFmpeg,
    private val ffProbe: FFprobe,
    @Value("\${kkywalk2.storage.path:./test}") private val rootPath: String
): VideoConverter {

    override fun convert(path: String, title: String): String {
        val result = File("$rootPath/$path/$title.m3u8")
        val builder = FFmpegBuilder()

        builder.setInput("$rootPath/$path/$title")
            .addOutput(result.absolutePath)
            .setFormat("hls")
            .addExtraArgs("-hls_time", "10")
            .addExtraArgs("-hls_list_size", "0")
            .addExtraArgs("-hls_segment_filename", "$rootPath/$path/$title%03d.ts")
            .addExtraArgs("-codec:", "copy")
            .done()

        val executor = FFmpegExecutor(ffMpeg, ffProbe)
        executor.createJob(builder).run()
        return "$rootPath/$path/$title.m3u8"
    }

}