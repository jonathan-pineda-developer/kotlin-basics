package com.firstapp.spacelog

import kotlin.random.Random

public open class User {
    private var id: String = generateRandomId()
    private var name: String = "jonathan_User"
    private var state: Float = 100F
    private var day: Int = 0
    private var menbership: Boolean = true
    private var sex: Char = 'M'

    constructor(id: String, name: String, state: Float, day: Int, menbership: Boolean, sex: Char) {
        this.id = id
        this.name = name
        this.state = state
        this.day = day
        this.menbership = menbership
        this.sex = sex
    }

    constructor() {
        this.id = id
        this.name = name
        this.state = state
        this.day = day
        this.menbership = menbership
        this.sex = sex
    }

    fun getId() = id
    fun getName() = name
    fun getState() = state
    fun getDay() = day
    fun getMenbership() = menbership
    fun getSex() = sex

    fun getString(genericString: String) = genericString
    fun getInt(genericInt: Int) = genericInt
    fun getBoolean(genericBoolean: Boolean) = genericBoolean
    fun getFloat(genericFloat: Float) = genericFloat
    fun getChar(genericChar: Char) = genericChar

    fun menbershipOn() {
        menbership = true
    }

    fun menbershipOff() {
        menbership = false
    }

    fun changeMenbership(genericBoolean: Boolean) {
        if (!genericBoolean) {
            menbershipOff()
        } else {
            menbershipOn()
        }
    }


    fun returnUser() {
        println(getId())
        println(getName())
        println(getState())
        println(getDay())
        println(getMenbership())
        println(getSex())

    }

    fun generateRandomId(n: Int = 8): String {
        val idSet = mutableSetOf<String>()
        val characterSet =
            "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!¿¡#$%&/()=?"
        val random = Random(System.nanoTime())
        var idRandom: String
        do {
            val idBuilder = StringBuilder()
            for (i in 0 until n) {
                val rIndex = random.nextInt(characterSet.length)
                idBuilder.append(characterSet[rIndex])
            }
            idRandom = idBuilder.toString()
        } while (idSet.contains(idRandom))
        idSet.add(idRandom)
        return idRandom
    }


}