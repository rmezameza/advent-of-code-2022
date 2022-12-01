package com.rmezameza.aoc

import com.rmezameza.days.Day1

/**
 * AoCHandler - Contains all the results of the days and provides function to get the list of results of a specific day.
 * Index 0 is occupied by a filler, so that the index with the first day starts at position 1.
 */
class AoCHandler {
    private val dayList : MutableList<MutableList<String>> = mutableListOf(mutableListOf("Filler", "Filler"))

    init {
        val day1 = Day1()
        this.dayList.add(day1.getResults())
    }

    fun getResultsOfSpecificDay(specificDay : Int) : MutableList<String> {
        return this.dayList.elementAt(specificDay)
    }


}