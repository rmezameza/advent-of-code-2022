package com.rmezameza.util

import java.io.File
import java.io.InputStream

import com.rmezameza.constants.FilePathConstants

class FileInputReader {

    fun readAllLine() : MutableList<String> {
        val inputStream : InputStream = File(FilePathConstants.INPUT_FILE_PATH + "test.txt").inputStream()
        val lineList : MutableList<String> = mutableListOf()

        inputStream.bufferedReader().forEachLine { lineList.add(it) }

        return lineList
    }

    fun readAllLinesAndTrim() : MutableList<String> {
        val inputStream : InputStream = File(FilePathConstants.INPUT_FILE_PATH + "test.txt").inputStream()
        val lineList : MutableList<String> = mutableListOf()

        inputStream.bufferedReader().forEachLine { it ->
            lineList.add(it.filter { !it.isWhitespace() })
        }

        return lineList
    }
}