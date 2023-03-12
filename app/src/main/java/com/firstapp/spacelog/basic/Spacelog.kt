package com.firstapp.spacelog.basic

import com.firstapp.spacelog.User
import kotlin.random.Random

class spacelog(
    user: User,
    private var idLog: String = user.generateRandomId(),
    private var date: String,
    private var description: String,
    private var distance: Double
) :
    User(user.getId(), user.getName(), user.getState(), user.getDay(), user.getMenbership(), user.getSex())
{
    constructor(
        id: String,
        name: String,
        state: Float,
        day: Int,
        membership: Boolean,
        idLog: String,
        date: String,
        description: String,
        sex: Char,
        distance: Double
    ) : this(User(id, name, state, day, membership, sex), idLog, date, description, distance)

    constructor(idLog: Int, description: String, date: String, user: User) : this(user, idLog.toString(), date, description, 0.0) {
        this.distance = generateNumber()
    }

    fun returnLog() {
        returnUser()
        println(getIdlog())
        println(getDate())
        println(getDescripcion())
        println(getDistance())
    }

    fun getIdlog() = idLog
    fun getDate() = date
    fun getDescripcion() = description
    fun getDistance(){
        generateNumber()
    }

    companion object {
        const val light: Double = 299792.458
        const val days: Int = 300
        const val seconds: Int = 86400
        const val distanceTravel: Double = 102000000.0
    }

    fun calculateDistanceTraveled(): Double {

        val travel = (distance / days) * distanceTravel
        return travel
    }

    fun generateNumber(): Double {

        var aux = Random.nextDouble(1.0, 102000000.0)
        distance = aux

        return distance
    }
}