package com.example.bloknotsql.db

import android.provider.BaseColumns

object MydbMyclass:BaseColumns {

    const val TABLE_NAME = "my_table"
    const val COLUMN_TABLE_TITLE = "title"
    const val COLUMN_TABLE_CONTENT = "content"
    const val COLUMN_TABLE_URI = "uri"
    const val DATABASE_VERSION = 2
    const val DATABASE_NAME = "MyBloknot.db"

    const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME ("+
            "${BaseColumns._ID} INTEGER PRIMARY KEY, $COLUMN_TABLE_TITLE TEXT, $COLUMN_TABLE_CONTENT TEXT, $COLUMN_TABLE_URI TEXT)"
     const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
}