package com.example.mablab3.lab3

open class Parcel(val id: String, val weightKg: Double) {
    init {
        require(id.isNotBlank()) { "ID cannot be blank" }
        require(weightKg > 0) { "Weight must be positive" }
    }

    open fun shippingCost(): Double = weightKg * 2.0
}

class ExpressParcel(id: String, weightKg: Double) : Parcel(id, weightKg) {
    override fun shippingCost(): Double {
        return super.shippingCost() + 15.0
    }
}

class EconomyParcel(id: String, weightKg: Double) : Parcel(id, weightKg) {
    override fun shippingCost(): Double {
        return super.shippingCost() * 0.8
    }
}

fun totalShipping(parcels: List<Parcel>): Double {
    var total = 0.0
    for (p in parcels) {
        total += p.shippingCost()
    }
    return total
}