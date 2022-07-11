package com.arunkbabu.androidtesting.model

import androidx.annotation.NonNull
import androidx.annotation.Nullable

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(@NonNull data: T, @NonNull message: String) : Resource<T>(data, message)
    class Loading<T>(@Nullable data: T? = null) : Resource<T>(data)
    class Error<T>(@Nullable data: T? = null, @NonNull msg: String) : Resource<T>(data,  msg)
}
