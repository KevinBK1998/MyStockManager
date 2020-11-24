package com.kbkapps.mystockmanager

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DatabaseHandler(
    context: Context?,
    name: String?
) : SQLiteOpenHelper(context, name ?: DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE $TABLE_STOCKS ($COLUMN_ID INTEGER PRIMARY KEY,$COLUMN_NAME TEXT,$COLUMN_DESCRIPTION TEXT,$COLUMN_QUANTITY INTEGER,$COLUMN_PRICE REAL)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_STOCKS")
        onCreate(db)
    }

    fun addItems(item: Item) {
        val values = ContentValues()
        values.put(COLUMN_NAME, item.name)
        values.put(COLUMN_DESCRIPTION, item.description)
        values.put(COLUMN_QUANTITY, item.quantity)
        values.put(COLUMN_PRICE, item.price)
        val db = this.writableDatabase
        Log.i("DBADD", db.insert(TABLE_STOCKS, null, values).toString())
    }

    fun findItem(itemName: String): Item? {
        val query =
            "SELECT * FROM $TABLE_STOCKS WHERE $COLUMN_NAME =  \"$itemName\""

        val db = this.writableDatabase

        val cursor = db.rawQuery(query, null)

        var item: Item? = null

        if (cursor.moveToFirst()) {
            cursor.moveToFirst()
            val id = Integer.parseInt(cursor.getString(0))
            val name = cursor.getString(1)
            val description = cursor.getString(2)
            val quantity = Integer.parseInt(cursor.getString(3))
            val price = cursor.getString(4).toFloat()
            Log.d("dbHandler", "id:$id")
            item = Item(name, description, quantity, price)
            cursor.close()
        }

        return item
    }

    fun all(): Item? {
        val query =
            "SELECT * FROM $TABLE_STOCKS"

        val db = this.writableDatabase

        val cursor = db.rawQuery(query, null)

        var item: Item? = null
        Log.i("DB", "start:${cursor.count},${cursor.columnCount},${cursor.columnNames}")

        if (cursor.moveToFirst()) {
            Log.i("DB", "first")

            cursor.moveToFirst()
            val id = Integer.parseInt(cursor.getString(0))
            val name = cursor.getString(1)
            val description = cursor.getString(2)
            val quantity = Integer.parseInt(cursor.getString(3))
            val price = cursor.getString(4).toFloat()
            Log.d("dbHandler", "id:$id")
            item = Item(name, description, quantity, price)
            cursor.close()
        }

        Log.i("DB", "end")

        return item
    }

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "stock-mgr.db"
        const val TABLE_STOCKS = "stocks"
        const val COLUMN_ID = "_id"
        const val COLUMN_NAME = "itemName"
        const val COLUMN_DESCRIPTION = "itemDesc"
        const val COLUMN_PRICE = "itemPrice"
        const val COLUMN_QUANTITY = "itemQuantity"
    }
}