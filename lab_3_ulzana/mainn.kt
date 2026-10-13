package com.example.mablab3.lab3

fun main() {
    // Task 1
    val s1 = Sensor("S-101", 22.5)
    s1.update(25.0)
    println(s1)

    // Task 2
    val counter = Counter()
    counter.inc(2)
    println(counter.value())

    // Task 3
    val car = Car("Toyota", 4)
    val bike = Bike("Trek", 18)
    println(car.info())
    println(bike.info())

    // Task 4
    val employees = listOf(
        Employee("Alice", 3000),
        Accountant("Bob", 4000, 10),
        Intern("Charlie", 2000, "Alice")
    )
    for (e in employees) {
        println(e.describe())
    }

    // Task 5
    val parcels = listOf(
        Parcel("P1", 2.0),
        ExpressParcel("P2", 2.0),
        EconomyParcel("P3", 2.0)
    )
    println(totalShipping(parcels))

    // Task 6,7
    val v: Vehicle = Car("Volvo", 4)
    printFleet(listOf(v, bike))
    println(doorsOrZero(v))

    // Task 8
    val q = Quiz("Kotlin", 100, 0.1)
    println(q.scoreTowardGrade(90))

    // Task 9
    val notes = listOf(
        EmailNotification("Hi", "mail@test.com"),
        SmsNotification("Code 123", "+12345")
    )
    sendAll(notes)

    // Task 10
    val tickets = listOf(
        AdultTicket("A-1", 100),
        ChildTicket("C-1", 100, "G-1")
    )
    println(checkout(tickets))
    println(childGuardianCodes(tickets))
}
}