package com.example.mablab3.lab3

open class Vehicle(val brand: String) {
    init {
        require(brand.isNotBlank()) { "Brand cannot be blank" }
    }

    open fun info(): String = "Vehicle: $brand"
    open fun maxSpeedKmh(): Int = 100
}

class Car(brand: String, val doors: Int) : Vehicle(brand) {
    init {
        require(doors >= 2) { "Car must have at least 2 doors" }
    }

    override fun info(): String = "Car $brand, doors=$doors"
    override fun maxSpeedKmh(): Int = 180
}

class Bike(brand: String, val gears: Int) : Vehicle(brand) {
    init {
        require(gears >= 1) { "Bike must have at least 1 gear" }
    }

    override fun info(): String = "Bike $brand, gears=$gears"
    override fun maxSpeedKmh(): Int = 30
}

fun printFleet(fleet: List<Vehicle>) {
    for (v in fleet) {
        println(v.info())
    }
}

fun doorsOrZero(v: Vehicle): Int {
    if (v is Car) {
        return v.doors
    }
    return 0
}