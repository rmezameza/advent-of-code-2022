package com.rmezameza.days

import com.rmezameza.aoc.AoCDay

class Day3 : AoCDay("day3.txt") {
    private val componentOne : MutableList<String> = mutableListOf()
    private val componentTwo : MutableList<String> = mutableListOf()
    private val threeStringGroups : MutableList<MutableList<String>> = mutableListOf(mutableListOf())
    private val alphabetValues : String = "-abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

    init {
        splitToTwoCompontents()
        partOne()

        createThreeGroupsOfString()
        partTwo()
    }
    override fun partOne() {
        this.results.add("The sum of the priorities of all common item types is: " + calculateSumOfCommonItems() )
    }

    override fun partTwo() {
        this.results.add("The sum of the priorities of groups by three: " + calculateSumOfItemByThreeGroup())
    }

    private fun splitToTwoCompontents() {
        this.stringInputList.forEach{
            val halfStringNumber : Int = it.length / 2

            this.componentOne.add(it.substring(0, halfStringNumber))
            this.componentTwo.add(it.substring(halfStringNumber, it.length))
        }
    }

    private fun createThreeGroupsOfString() {
        var tempThreeStringGroup : MutableList<String> = mutableListOf()
        var count = 0

        this.stringInputList.forEach {
            tempThreeStringGroup.add(it)
            ++count

            if(count % 3 == 0) {
                count = 0
                this.threeStringGroups.add(tempThreeStringGroup)
                tempThreeStringGroup = mutableListOf()
            }
        }

        this.threeStringGroups.removeAt(0)
    }

    private fun calculateSumOfCommonItems() : Int {
        var sumOfCommonItems = 0

        for(i in this.componentOne.indices) {
            for(j in this.componentOne[i].indices) {
                val actualCharInComponentOne : String = this.componentOne[i][j].toString()

                if(this.componentTwo[i].contains(actualCharInComponentOne)) {
                    sumOfCommonItems += this.alphabetValues.indexOf(actualCharInComponentOne)
                    break
                }
            }
        }

        return sumOfCommonItems
    }

    private fun calculateSumOfItemByThreeGroup() : Int {
        var sumOfCommonItemByThreeGroup = 0

        this.threeStringGroups.forEach {
            for(i in this.alphabetValues.indices) {
                val actualChar : String = this.alphabetValues[i].toString()

                if(it[0].contains(actualChar) && it[1].contains(actualChar) && it[2].contains(actualChar)) {
                    sumOfCommonItemByThreeGroup += this.alphabetValues.indexOf(this.alphabetValues[i])
                    break
                }
            }
        }

        return sumOfCommonItemByThreeGroup
    }
}