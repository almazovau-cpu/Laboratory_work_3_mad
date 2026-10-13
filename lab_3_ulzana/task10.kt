package com.example.mablab3.lab3

open class Ticket(val code: String, val basePrice: Int) {
    init {
        require(code.isNotBlank()) { "Code cannot be blank" }
        require(basePrice >= 0) { "Price cannot be negative" }
    }

    open fun price(): Int = basePrice
}

class AdultTicket(code: String, basePrice: Int) : Ticket(code, basePrice)

class ChildTicket(code: String, basePrice: Int, val guardianCode: String) : Ticket(code, basePrice) {
    init {
        require(guardianCode.isNotBlank()) { "Guardian code required" }
    }

    override fun price(): Int {
        return super.price() / 2
    }
}

class VipTicket(code: String, basePrice: Int, val loungeAccess: Boolean) : Ticket(code, basePrice) {
    override fun price(): Int {
        val extra = if (loungeAccess) 50 else 20
        return super.price() + extra
    }
}

fun checkout(tickets: List<Ticket>): Int {
    var sum = 0
    for (t in tickets) {
        sum += t.price()
    }
    return sum
}

fun childGuardianCodes(tickets: List<Ticket>): List<String> {
    val result = mutableListOf<String>()
    for (t in tickets) {
        if (t is ChildTicket) {
            result.add(t.guardianCode)
        }
    }
    return result
}