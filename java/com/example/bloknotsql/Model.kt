package com.example.bloknotsql

class Model( title: String?, description: String?) {
    private var title: String
    private var decription: String

    init {

        this.title = title!!
        this.decription = description!!
    }


    fun getTitle():String?{
        return title
    }
    fun setTitle(name:String?){
        title = name!!
    }
    fun getDescription():String?{
        return decription
    }
    fun setDescription(desc:String?){
        decription = desc!!
    }
}