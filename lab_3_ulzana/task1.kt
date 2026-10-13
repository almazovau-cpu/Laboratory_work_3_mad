package com.example.mablab3.lab3

class Sensor(val id: String, var reading: Double) {
    init {
        require(id.isNotBlank()) { "ID cannot be blank" }
    }

    fun update(newReading: Double) {
        require(newReading.isFinite()) { "Reading must be finite" }
        reading = newReading
    }

    override fun toString(): String {
        return "Sensor(id=$id, reading=$reading)"
    }
}