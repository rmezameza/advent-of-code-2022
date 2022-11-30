package com.rmezameza.util

import java.io.File
import java.io.InputStream

class FileInputReader {
    fun readAllLine() : MutableList<String> {
        val inputStream : InputStream = File("./input/test.txt").inputStream()
        val lineList : MutableList<String> = mutableListOf<String>()

        inputStream.bufferedReader().forEachLine { lineList.add(it) }

        return lineList
    }
}