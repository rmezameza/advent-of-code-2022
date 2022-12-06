package com.rmezameza.days

import com.rmezameza.aoc.AoCDay
import com.rmezameza.enums.MyHandDay3
import com.rmezameza.enums.ResultValuesDay3

class Day2 : AoCDay("day2.txt") {
    private val gameGrouped : MutableList<MutableList<String>> = mutableListOf(mutableListOf())

    init {
        makeGameGroups()
        partOne()

        partTwo()
    }
    override fun partOne() {
        this.results.add("Total Score according strategy guide: " + getTotalScore(getGameResultValues()))
    }

    override fun partTwo() {
        this.results.add("Total Score according the new ultra top secrete guide: " + getTotalScorePart2())
    }

    private fun makeGameGroups() {
        this.stringInputListTrimmed.forEach {
            this.gameGrouped.add(mutableListOf(it))
        }

        this.gameGrouped.removeAt(0)
    }

    private fun getGameResultValues() : MutableList<Int> {
        val resultValuesOfGames : MutableList<Int> = mutableListOf()

        this.gameGrouped.forEach {
            when (it.toString()) {
                "[AZ]", "[BX]", "[CY]" -> {
                    resultValuesOfGames.add(ResultValuesDay3.LOST.resultValue)
                }
                "[AX]", "[BY]", "[CZ]" -> {
                    resultValuesOfGames.add(ResultValuesDay3.DRAW.resultValue)
                }
                else -> {
                    resultValuesOfGames.add(ResultValuesDay3.WIN.resultValue)
                }
            }
        }

        return resultValuesOfGames
    }

    private fun getTotalScore(resultValuesOfGame : MutableList<Int>) : Int {
        val scoreList : MutableList<Int> = mutableListOf()

        for(i in this.gameGrouped.indices) {
            val currentGroup : String = this.gameGrouped[i].toString()

            when(currentGroup[2].toString()) {
                MyHandDay3.X.handChar -> {
                    scoreList.add(MyHandDay3.X.handValue)
                }
                MyHandDay3.Y.handChar -> {
                    scoreList.add(MyHandDay3.Y.handValue)
                }
                else -> {
                    scoreList.add(MyHandDay3.Z.handValue)
                }
            }

            scoreList[i] += resultValuesOfGame[i]
        }

        return scoreList.sum()
    }

    private fun getTotalScorePart2() : Int {
        val myHandSymbols : MutableList<Char> = mutableListOf()
        val valuesOfMyHand : MutableList<Int> = mutableListOf()

        this.gameGrouped.forEach {
            myHandSymbols.add(it.toString()[2])
        }

        for(i in myHandSymbols.indices) {
            val actualGameRound : String = this.gameGrouped[i].toString()

            when(myHandSymbols[i]) {
                ResultValuesDay3.LOST.equalToMyHand -> {
                    valuesOfMyHand.add(ResultValuesDay3.LOST.resultValue)
                }
                ResultValuesDay3.DRAW.equalToMyHand -> {
                    valuesOfMyHand.add(ResultValuesDay3.DRAW.resultValue)
                }
                else -> {
                    valuesOfMyHand.add(ResultValuesDay3.WIN.resultValue)
                }
            }

            valuesOfMyHand[i] += checkValueBasedOnOpponent(actualGameRound)
        }

        return valuesOfMyHand.sum()
    }

    private fun checkValueBasedOnOpponent(actualGameRound : String) : Int {
        return when(actualGameRound) {
            "[BX]", "[AY]", "[CZ]" -> {
                MyHandDay3.X.handValue
            }
            "[CX]", "[BY]", "[AZ]" -> {
                MyHandDay3.Y.handValue
            }
            else -> {
                MyHandDay3.Z.handValue
            }
        }
    }
}