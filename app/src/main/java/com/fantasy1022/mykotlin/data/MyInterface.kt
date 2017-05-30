package com.fantasy1022.mykotlin.data

/**
 * Created by fantasy_apple on 2017/5/28.
 */
interface MyInterface {
    val prop: Int // abstract

    val propertyWithImplementation: String
        get() = "foo"

    fun foo() {
        print(prop)
    }
}