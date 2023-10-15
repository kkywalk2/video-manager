package me.kkywalk2.videomanager.core

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

@Service
class LocalStorageManager(
    @Value("\${kkywalk2.storage.path:./test}") private val rootPath: String
): StorageManager {

    override fun readFile(path: String): File {
        val filePath = "$rootPath/$path"
        return File(filePath)
    }

    override fun uploadFile(path: String, byte: ByteArray) {
        Files.write(Paths.get("$rootPath/$path"), byte)
    }

}