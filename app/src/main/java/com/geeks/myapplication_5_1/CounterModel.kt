package com.geeks.myapplication_5_1

class CounterModel {
    private var count = 0

    fun inc(){
        count ++
    }
    fun dec(){
        count--
    }

    fun getResult() = count
}