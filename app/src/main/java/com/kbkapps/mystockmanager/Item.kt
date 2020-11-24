package com.kbkapps.mystockmanager

class Item {
    var id: Int = 0
    var name:String?=null
    var description:String?=null
    var quantity: Int = 0
    var price: Float = 0f

    constructor(id: Int, name: String,description: String, quantity: Int,price: Float):this(name,description, quantity, price) {
        this.id = id
    }

    constructor(name: String,description: String, quantity: Int,price: Float) {
        this.name = name
        this.description = description
        this.quantity = quantity
        this.price = price
    }
    override fun toString(): String {
        return "name:$name,desc:$description,qty:$quantity,rate:$price"
    }
}