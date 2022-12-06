package com.rmezameza.aoc

import com.rmezameza.util.FileInputReader

abstract class AoCDay (textFileName : String) {
    private val fileInputReader = FileInputReader()
    protected var stringInputList : MutableList<String> = mutableListOf()
    protected var stringInputListTrimmed : MutableList<String> = mutableListOf()
    protected var results : MutableList<String> = mutableListOf()

    init {
        this.stringInputList = fileInputReader.readAllLine(textFileName)
        this.stringInputListTrimmed = fileInputReader.readAllLinesAndTrim(textFileName)
    }

    abstract fun partOne()
    abstract fun partTwo()
    fun getDayResults() : MutableList<String> {
        return this.results
    }

    companion object

}