package com.example.bloknotsql.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context:Context):SQLiteOpenHelper(context, MydbMyclass.DATABASE_NAME, null, MydbMyclass.DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL(MydbMyclass.CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {

        db?.execSQL(MydbMyclass.SQL_DELETE_TABLE)
        onCreate(db)
    }
}