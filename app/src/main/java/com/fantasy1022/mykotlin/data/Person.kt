package com.fantasy1022.mykotlin.data

/**
 * Created by fantasy_apple on 2017/5/28.
 */
open class Person(val name: String, val surname: String) {
    fun getFullName() = "$name $surname"
}