package com.firstapp.spacelog





import java.util.Date


/**
 * Fundamentals kotlin
 * */




fun main() {

    val user1 = User()

    var genericString: String = "Welcome New Star Citizen to spaceLog app!\n"
    var id: String = "CAD-100"
    var name: String = "Jonathan"
    var state: Float = 100F
    var day: Int = 0
    var menbership: Boolean = true
    var sex: Char = 'H'
    var idLog: String = "IDF-100"
    var date: String = "12 de agosto"
    var description: String = "Bitacora del Cadete"
    var distance: Double = 0.0


    val user2 = User(id, name, state, day, menbership, sex)
    var spaceLog = spacelog(user2, idLog, date, description,distance)

    print(genericString)
    println(spaceLog.returnLog())


    spaceLog = spacelog(user1, user1.generateRandomId(), date, description,spaceLog.calculateDistanceTraveled())
    println(spaceLog.returnLog())
    println("---------ROOM---------")
    var desc:String = ""
    val room = Room(user1,user1.generateRandomId(),user1.getMenbership(),desc)
    println(room.returnRoom())


}



