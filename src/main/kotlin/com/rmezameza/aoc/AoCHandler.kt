package com.rmezameza.aoc

import com.rmezameza.days.Day1
import com.rmezameza.days.Day2
import com.rmezameza.days.Day3

/**
 * AoCHandler - Contains all the results of the days and provides function to get the list of results of a specific day.
 * Index 0 is occupied by a filler, so that the index with the first day starts at position 1.
 */
class AoCHandler {
    private val dayList : MutableList<MutableList<String>> = mutableListOf(mutableListOf("Filler", "Filler"))

    init {
        val day1 = Day1()
        this.dayList.add(day1.getDayResults())

        val day2 = Day2()
        this.dayList.add(day2.getDayResults())

        val day3 = Day3()
        this.dayList.add(day3.getDayResults())
    }

    fun getResultsOfSpecificDay(specificDay : Int) : MutableList<String> {
        return this.dayList.elementAt(specificDay)
    }
}
