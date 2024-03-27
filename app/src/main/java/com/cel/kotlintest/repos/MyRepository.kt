package com.cel.kotlintest.repos

class MyRepository {
    suspend fun counting(count: Int): Int{
        var c=count
        c++
        return c
    }
}