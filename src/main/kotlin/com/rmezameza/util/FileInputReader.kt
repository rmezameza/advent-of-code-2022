package com.rmezameza.util

import java.io.File
import java.io.InputStream

import com.rmezameza.constants.FilePathConstants

class FileInputReader {

    fun readAllLine(dayInputTextFile : String) : MutableList<String> {
        val inputStream : InputStream = File(FilePathConstants.INPUT_FILE_PATH + dayInputTextFile).inputStream()
        val lineList : MutableList<String> = mutableListOf()

        inputStream.bufferedReader().forEachLine { lineList.add(it) }

        return lineList
    }

    fun readAllLinesAndTrim(dayInputTextFile : String) : MutableList<String> {
        val inputStream : InputStream = File(FilePathConstants.INPUT_FILE_PATH + dayInputTextFile).inputStream()
        val lineList : MutableList<String> = mutableListOf()

        inputStream.bufferedReader().forEachLine { it ->
            lineList.add(it.filter { !it.isWhitespace() })
        }

        return lineList
    }
}