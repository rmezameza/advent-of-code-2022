package com.rmezameza.days

import com.rmezameza.util.FileInputReader

class Day1 {
    private val fileInputReader = FileInputReader()
    private val stringInputList : MutableList<String> = fileInputReader.readAllLine("day1.txt")
    private val results : MutableList<String> = mutableListOf()

    init {
        day11()
        day12()
    }

    fun getResults() : MutableList<String>{
        return this.results
    }
    private fun day11() {
        this.results.add("The most calories carried by an elve: " + getSumCaloriesPerElveList().max())
    }

    private fun day12() {
        val sumCaloriesPerElveList : MutableList<Int> = getSumCaloriesPerElveList()
        var finalSum = 0
        var tempMax: Int

        for(i in 1..3) {
            tempMax = sumCaloriesPerElveList.max()
            finalSum += tempMax
            sumCaloriesPerElveList.remove(tempMax)
        }

        this.results.add("The sum of the three most calories is: $finalSum")
    }

    private fun getSumCaloriesPerElveList() : MutableList<Int> {
        val sumCaloriesPerElveList : MutableList<Int> = mutableListOf()
        var tempSum = 0

        this.stringInputList.forEach{
            if(it != "") {
                tempSum += it.toInt()
            } else {
                sumCaloriesPerElveList.add(tempSum)
                tempSum = 0
            }
        }

        return sumCaloriesPerElveList;
    }
}