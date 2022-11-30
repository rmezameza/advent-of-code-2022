package com.rmezameza

import com.rmezameza.util.FileInputReader

fun main() {
    val fileInputReader = FileInputReader()
    val lineList : MutableList<String> = fileInputReader.readAllLine()
    val lineListTrim : MutableList<String> = fileInputReader.readAllLinesAndTrim()

    println("Test line print:")
    lineList.forEach{println (it)}

    println("\nAnother test line print with trim")
    lineListTrim.forEach{println (it)}
}