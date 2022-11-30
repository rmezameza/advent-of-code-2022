package com.rmezameza

import com.rmezameza.util.FileInputReader

fun main() {
    val fileInputReader = FileInputReader()
    val lineList : MutableList<String> = fileInputReader.readAllLine()

    println("Test line print:")
    lineList.forEach{println (it)}
}