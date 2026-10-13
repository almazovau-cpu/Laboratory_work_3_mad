package com.example.mablab3.lab3

open class Employee(val name: String, val baseSalary: Int) {
    init {
        require(name.isNotBlank()) { "Name cannot be blank" }
        require(baseSalary >= 0) { "Salary cannot be negative" }
    }

    open fun pay(): Int = baseSalary
    open fun describe(): String = "$name: ${pay()}"
}

class Accountant(name: String, baseSalary: Int, val bonusPercent: Int) : Employee(name, baseSalary) {
    init {
        require(bonusPercent in 0..100) { "Bonus must be between 0 and 100" }
    }

    override fun pay(): Int {
        return super.pay() + (super.pay() * bonusPercent / 100)
    }

    override fun describe(): String {
        return "Accountant " + super.describe()
    }
}

class Intern(name: String, baseSalary: Int, val mentor: String) : Employee(name, baseSalary) {
    init {
        require(mentor.isNotBlank()) { "Mentor name cannot be blank" }
    }

    override fun pay(): Int {
        return super.pay() / 2
    }
}