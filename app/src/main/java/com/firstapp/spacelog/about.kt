package com.firstapp.spacelog
import java.lang.reflect.Field

import java.util.Date


/**
 * Fundamentals kotlin
 * */
public open class User{
    private var id: String = "100-SpaceLog%id=?"
    private var name: String ="User Name"
    private var state: Float = 100F
    private var day: Int = 0
    private var menbership: Boolean = true
    private var sex: Char = 'M'

    constructor(id: String, name: String, state: Float,day: Int,menbership: Boolean, sex: Char){
        this.id = id
        this.name = name
        this.state = state
        this.day = day
        this.menbership = menbership
        this.sex = sex
    }
    constructor(){
        this.id = id
        this.name = name
        this.state = state
        this.day = day
        this. menbership = menbership
        this.sex = sex
    }

    fun getId() = id
    fun getName() = name
    fun getState() = state
    fun getDay() = day
    fun getMenbership() = menbership
    fun getSex() = sex

    fun getString(genericString: String): String{
        return genericString
    }
    fun getInt(genericInt: Int): Int{
        return genericInt
    }
    fun getBoolean(genericBoolean: Boolean): Boolean{
        return genericBoolean
    }
    fun getFloat(genericFloat: Float): Float{
        return genericFloat
    }
    fun getChar(genericChar: Char): Char{
        return genericChar
    }
    fun menbershipOn(){
        menbership = true
    }
    fun menbershipOff(){
        menbership = false
    }
    fun changeMenbership(genericBoolean: Boolean) {
        if (!genericBoolean) {
            menbershipOff()
        } else {
            menbershipOn()
        }
    }
    fun returnUser(){
        println(getId())
        println(getName())
        println(getState())
        println(getDay())
        println(getMenbership())
        println(getSex())

    }


}
class spacelog(
    user: User,
    private var idLog: String,
    private var date: String,
    private var description: String
) :
    User(user.getString(user.getId()),user.getString(user.getName()),
            user.getFloat(user.getState()), user.getInt(user.getDay()),
            user.getBoolean(user.getMenbership()),user.getChar(user.getSex())) {

    constructor(
        id: String,
        name: String,
        state: Float,
        day: Int,
        membership: Boolean,
        idLog: String,
        date: String,
        description: String,
        sex: Char
    ) : this(User(id, name, state, day, membership,sex), idLog, date, description)
    fun returnLog(){
        returnUser()
        println(getIdlog())
        println(getDate())
        println(getDescripcion())

    }
    fun getIdlog() = idLog
    fun getDate() = date
    fun getDescripcion() = description


}

fun main(){

    var genericString: String = "Welcome New Star Citizen to spaceLog app!\n"
    var id: String = "CAD-100"
    var name: String ="Jonathan"
    var state: Float = 100F
    var day: Int = 0
    var menbership: Boolean = true
    var sex: Char = 'H'
    var idLog: String = "IDF-100"
    var date: String = "12 de agosto"
    var description: String = "Bitacora del Cadete"

    val user1 = User()
    val user2 = User(id,name,state,day,menbership,sex)
    var spaceLog = spacelog(user2, idLog,date,description)

    print(genericString)
    println(spaceLog.returnLog())

    println("------------------")

    spaceLog = spacelog(user1, idLog,date,description)
    println(spaceLog.returnLog())





}


