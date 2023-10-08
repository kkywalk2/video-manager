package me.kkywalk2.videomanager

import net.bramp.ffmpeg.FFmpeg
import net.bramp.ffmpeg.FFmpegExecutor
import net.bramp.ffmpeg.FFprobe
import net.bramp.ffmpeg.builder.FFmpegBuilder
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.io.File

@SpringBootTest
class VideoManagerApplicationTest {

    @Autowired
    lateinit var ffMpeg: FFmpeg

    @Autowired
    lateinit var ffProbe: FFprobe

    @Test
    fun ffMpegTest() {
        val result = File("./test/result.m3u8")
        val builder = FFmpegBuilder()

        builder.setInput("sample.mp4")
            .addOutput(result.absolutePath)
            .setFormat("hls")
            .addExtraArgs("-hls_time", "10")
            .addExtraArgs("-hls_list_size", "0")
            .addExtraArgs("-hls_segment_filename", "./test/result%03d.ts")
            .addExtraArgs("-codec:", "copy")
            .done()

        val executor = FFmpegExecutor(ffMpeg, ffProbe)
        executor.createJob(builder).run()
    }

}
