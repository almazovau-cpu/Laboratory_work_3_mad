package com.example.mablab3.lab3

class Counter(start: Int = 0) {
    private var count = start

    fun value(): Int = count

    fun inc(step: Int = 1) {
        require(step > 0) { "Step must be positive" }
        count += step
    }

    fun reset() {
        count = 0
    }
}