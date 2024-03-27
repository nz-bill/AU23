package com.example.realmexempel


import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class User: RealmObject {

    @PrimaryKey
    var _id: ObjectId = ObjectId()

    var name: String = ""
    var score: Double = 0.0
    var isHuman: Boolean = false


    override fun toString(): String {
        return "_id=$_id, " +
                "name='$name', " +
                "score=$score, " +
                "isHuman=$isHuman"
    }


}