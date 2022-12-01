package com.rmezameza

import com.rmezameza.aoc.AoCHandler
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
fun main() {
    val aocHandler = AoCHandler()


    print("Please enter day number (1 - 1): ")
    val inputDay = readln()
    val resultsOfActualDay : MutableList<String> = aocHandler.getResultsOfSpecificDay(inputDay.toInt())

    println("\nResults of Day $inputDay:\n")
    resultsOfActualDay.forEach{ println(it) }
}