package com.example.bloknotsql.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class MyDbManager(private val context: Context) {

    private val MyDbHelper = DBHelper(context)
    var db: SQLiteDatabase? = null

    fun openDB() {

        db = MyDbHelper.writableDatabase

    }

    fun insertToDb(title: String, content: String, uri: String) {

        val values = ContentValues().apply {
            put(MydbMyclass.COLUMN_TABLE_TITLE, title)
            put(MydbMyclass.COLUMN_TABLE_CONTENT, content)
            put(MydbMyclass.COLUMN_TABLE_URI, uri)
        }
        db?.insert(MydbMyclass.TABLE_NAME, null, values)
    }

    fun removeItemDB(id: String) {

        val selection = BaseColumns._ID + "=$id"

        db?.delete(MydbMyclass.TABLE_NAME, selection, null)
    }

    fun readDbData(searchText: String): ArrayList<ListItem> {

        val dataList = ArrayList<ListItem>()
        val selection = "${MydbMyclass.COLUMN_TABLE_TITLE} like ?"


        val cursor = db?.query(
            MydbMyclass.TABLE_NAME,
            null,
            selection,
            arrayOf("%$searchText%"),
            null,
            null,
            null
        )



        while (cursor?.moveToNext()!!) {
            val dataText = cursor.getString(cursor.getColumnIndex(MydbMyclass.COLUMN_TABLE_TITLE))
            val dataText2 = cursor.getString(cursor.getColumnIndex(MydbMyclass.COLUMN_TABLE_CONTENT))
            val dataText3 = cursor.getString(cursor.getColumnIndex(MydbMyclass.COLUMN_TABLE_URI))
            val dataId = cursor.getInt(cursor.getColumnIndex(BaseColumns._ID))
            val item = ListItem()
            item.task = dataText
            item.title = dataText2
            item.uri = dataText3
            item.id = dataId
            dataList.add(item)
        }


        cursor.close()
        return dataList

    }

    fun closeDb() {
        MyDbHelper.close()
    }
}