package com.fantasy1022.mykotlin.data

import kotlin.properties.Delegates

/**
 * Created by fantasy_apple on 2017/5/28.
 */
data class Animal(val name: String, val age: Int) {

    val lazy: String by Delegates.notNull()
}