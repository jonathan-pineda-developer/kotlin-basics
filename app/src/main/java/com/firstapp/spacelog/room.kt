package com.firstapp.spacelog

import java.io.FileDescriptor

open class Room(
    private val user: User,
    private var id: String = user.generateRandomId(),
    private var status: Boolean = user.getMenbership(),
    private var description: String = ""
) : User() {

    init {
        this.id = id
        this.status = status
        this.description = description
    }

    fun getID(): String = this.id

    fun getStatus(): Boolean = this.status

    fun getDescription(): String = this.description

    fun returnRoom() {
        println("Room ID: ${getID()}")
        println("Room Status: ${getStatus()}")
        println("Room Description: ${getDescription()}")
        println("${user.returnUser()}")
    }
}