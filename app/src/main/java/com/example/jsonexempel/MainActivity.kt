package com.example.jsonexempel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       //jsonArray()
        //jsonObject()
        //objectToJson()
        //objectToStringGson()
        //stringToObjectGson()
        //stringToArrayGson()
        jsonArrayToJavaListGson()

    }

    fun jsonArray(){
        val jsonString = "[{\"name\":\"Bill Palmestedt\",\"salary\":65000},{\"name\":\"Bosse Bus\",\"salary\":75000}]"

        val jsonArray = JSONArray(jsonString)
        println("jsonString = ${jsonString}")
        println("jsonArray = ${jsonArray}")

        val jsonObject1 = jsonArray.getJSONObject(0)
        val jsonObject2 = jsonArray.getJSONObject(1)

        println("jsonObject1 = ${jsonObject1}")
        println("obj1 name ${jsonObject1.get("name")}")
        println("obj2 name ${jsonObject2.get("name")}")

        val obj1 = User(jsonObject1.getString("name"),jsonObject1.getInt("salary"))

        println("obj1 = ${obj1}")
    }

    fun jsonObject(){
        val jsonString = "{\"users\":[{\"name\":\"Bill Palmestedt\",\"salary\":65000},{\"name\":\"Bosse Bus\",\"salary\":75000}]}"

        val jsonObject = JSONObject(jsonString)

        val jsonArray = jsonObject.getJSONArray("users")

        println("jsonString = ${jsonString}")
        println("jsonObject = ${jsonObject}")
        println("jsonArray = ${jsonArray}")

        val jsonObject1 = jsonArray.getJSONObject(0)
        val jsonObject2 = jsonArray.getJSONObject(1)

        println("jsonObject1 = ${jsonObject1}")
        println("obj1 name ${jsonObject1.get("name")}")
        println("obj2 name ${jsonObject2.get("name")}")

        val obj1 = User(jsonObject1.getString("name"),jsonObject1.getInt("salary"))

        println("obj1 = ${obj1}")


    }

    fun objectToJson(){

        val user = User("Bill", 50)

        val jsonString = user.toJSon()

        val jsonObject = JSONObject(jsonString)

        println("jsonString = ${jsonString}")

        println("jsonObject = ${jsonObject}")

    }

    fun objectToStringGson(){

        val user = User("Bosse", 100)

        val gson = Gson()

        val jsonString = gson.toJson(user)

        println("jsonString = ${jsonString}")

    }
    
    fun stringToObjectGson(){
        val jsonString = "{\"name\":\"Bill Palmestedt\",\"salary\":65000}"
        
        val gson = Gson()
        
        val user = gson.fromJson(jsonString,User::class.java)

        println("user.toString() = ${user.toString()}")
        
    }

    fun stringToArrayGson(){
        val jsonString = "[{\"name\":\"Bill Palmestedt\",\"salary\":65000},{\"name\":\"Bosse Bus\",\"salary\":75000}]"

        val gson = Gson()

        val userList: ArrayList<User> = gson.fromJson(jsonString, object: TypeToken<ArrayList<User>>(){}.type)

        println("userList = ${userList}")


    }

    fun jsonArrayToJavaListGson(){
        val jsonString = "[{\"name\":\"Bill Palmestedt\",\"salary\":65000},{\"name\":\"Bosse Bus\",\"salary\":75000}]"
        val jsonArray = JSONArray(jsonString)

        val  gson = Gson()
        val userList = ArrayList<User>()
        for (i in 0 until jsonArray.length()){
            val user = jsonArray.getJSONObject(i)
            val userObj = gson.fromJson(user.toString(), User::class.java)
            userList.add(userObj)
        }


        println("userList = ${userList}")
    }
}