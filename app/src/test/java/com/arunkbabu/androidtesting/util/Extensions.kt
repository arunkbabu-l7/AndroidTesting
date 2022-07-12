package com.arunkbabu.androidtesting.util

import org.mockito.Mockito

fun <T> any(): T {
    Mockito.any<T>()
    return uninitialized()
}

fun <T> any(type: Class<T>): T {
    return Mockito.any(type)
}

private fun <T> uninitialized(): T = null as T