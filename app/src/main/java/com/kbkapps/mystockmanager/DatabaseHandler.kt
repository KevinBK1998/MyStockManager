package com.kbkapps.mystockmanager

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createStocksTable = ("CREATE TABLE " +
                TABLE_STOCKS+ "("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_DESCRIPTION + " TEXT,"
                + COLUMN_QUANTITY + " INTEGER,"
                + COLUMN_PRICE + " REAL" + ")")
        db?.execSQL(createStocksTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS " + TABLE_STOCKS)
        onCreate(db)
    }
    fun addItems(item: Item) {
        val values = ContentValues()
        values.put(COLUMN_NAME, item.name)
        values.put(COLUMN_DESCRIPTION, item.description)
        values.put(COLUMN_QUANTITY, item.quantity)
        values.put(COLUMN_PRICE, item.price)
        val db = this.writableDatabase
        db.insert(TABLE_STOCKS, null, values)
        db.close()
    }

    companion object {

//        private val DATABASE_VERSION = 1
//        private val DATABASE_NAME = "stock-mgr.db"
        val TABLE_STOCKS = "stocks"

        val COLUMN_ID = "_id"
        val COLUMN_NAME = "itemName"
        val COLUMN_DESCRIPTION = "itemDesc"
        val COLUMN_PRICE = "itemPrice"
        val COLUMN_QUANTITY = "itemQuantity"
    }
}