package me.kkywalk2.videomanager.core

import java.io.File

interface StorageManager {

    fun readFile(path: String): File

    fun uploadFile(path: String, byte: ByteArray)

}
