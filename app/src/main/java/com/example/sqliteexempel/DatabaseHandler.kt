package com.example.sqliteexempel


import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler(context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object{
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "user_database"
        const val TABLE_USERS = "users"
        const val KEY_ID = "id"
        const val KEY_NAME = "name"
        const val KEY_SCORE = "score"
        const val KEY_IS_HUMAN = "is_human"
    }
    override fun onCreate(db: SQLiteDatabase?) {
       val createTableQuery = "CREATE TABLE $TABLE_USERS ($KEY_ID INTEGER PRIMARY KEY AUTOINCREMENT, $KEY_NAME TEXT, $KEY_SCORE REAL, $KEY_IS_HUMAN BOOL)"

        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_USERS")
        onCreate(db)
    }

    fun addUser(user: User): Boolean{
        val db = this.writableDatabase

        val values = ContentValues()

        values.put(KEY_NAME, user.name)
        values.put(KEY_SCORE, user.score)
        values.put(KEY_IS_HUMAN, user.isHuman)

        val insert = db.insert(TABLE_USERS, null, values)

        db.close()

        if(insert == -1L){
            return false
        } else return true


    }

    fun getAllUsers(): List<User>{

        val users = ArrayList<User>()
        val query = "SELECT * FROM $TABLE_USERS"
        val db = this.readableDatabase

        val cursor: Cursor = db.rawQuery(query, null)

        if(cursor.moveToFirst()){
            do{
                val id = cursor.getInt(0)
                val name = cursor.getString(1)
                val score = cursor.getDouble(2)
                val isHuman: Boolean = cursor.getInt(3) == 1

                val user = User(id, name, score, isHuman)
                users.add(user)
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()
        return users

    }

    fun updateUser(user: User){
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(KEY_NAME, user.name)
            put(KEY_SCORE, user.score)
            put(KEY_IS_HUMAN, user.isHuman)
        }

        db.update(TABLE_USERS, values, "$KEY_ID = ?", arrayOf(user.id.toString()))

        db.close()
    }

    fun deleteUSer(user: User): Boolean{
        val db = this.writableDatabase
        val query = "DELETE FROM $TABLE_USERS WHERE $KEY_ID = ${user.id}"

        val cursor : Cursor = db.rawQuery(query, null)
        val result = cursor.moveToFirst()
        cursor.close()

        return result


    }
}