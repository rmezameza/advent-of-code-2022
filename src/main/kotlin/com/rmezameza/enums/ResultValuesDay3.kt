package com.rmezameza.enums

enum class ResultValuesDay3(val equalToMyHand : Char, val resultValue : Int) {
    LOST('X', 0),
    DRAW('Y', 3),
    WIN('Z', 6);
}