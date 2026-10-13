package com.example.mablab3.lab3

open class Notification(private val payload: String) {
    init {
        require(payload.isNotBlank()) { "Payload cannot be blank" }
    }

    protected fun body(): String = payload
    open fun render(): String = body()
}

class EmailNotification(payload: String, val to: String) : Notification(payload) {
    override fun render(): String {
        return "Email to $to: ${body()}"
    }
}

class SmsNotification(payload: String, val phone: String) : Notification(payload) {
    override fun render(): String {
        return "SMS to $phone: ${body()}"
    }
}

fun sendAll(items: List<Notification>) {
    for (item in items) {
        println(item.render())
    }
}