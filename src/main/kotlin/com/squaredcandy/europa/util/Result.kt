package com.squaredcandy.europa.util

sealed class Result<out T> {
    data class Success<S>(val value: S): Result<S>()
    data class Failure(val throwable: Throwable): Result<Nothing>()
}

fun <R, T : R> getResult(block: () -> R): Result<R> {
    return try {
        Result.Success(block())
    } catch (throwable: Throwable) {
        Result.Failure(throwable)
    }
}

private suspend fun <T> getResultSuspended(block: suspend () -> T): Result<T> {
    return try {
        Result.Success(block())
    } catch (throwable: Throwable) {
        Result.Failure(throwable)
    }
}

fun <R, T : R> Result<T>.onSuccess(onSuccess: (value: R) -> Unit): Result<R> {
    return when(this) {
        is Result.Success -> { onSuccess(this.value); this }
        is Result.Failure -> this
    }
}

fun <R, T : R> Result<T>.onFailure(onFailure: (throwable: Throwable) -> Unit): Result<R> {
    return when(this) {
        is Result.Success -> this
        is Result.Failure -> { onFailure(this.throwable); this }
    }
}

fun <T> Result<T>.isSuccess(): Boolean {
    return when(this) {
        is Result.Success -> true
        is Result.Failure -> false
    }
}

fun <T> Result<T>.isFailure(): Boolean {
    return when(this) {
        is Result.Success -> false
        is Result.Failure -> true
    }
}

fun <R, T : R> Result<T>.getValueOrNull(): R? {
    return when(this) {
        is Result.Success -> this.value
        is Result.Failure -> null
    }
}

fun <T> Result<T>.getThrowableOrNull(): Throwable? {
    return when(this) {
        is Result.Success -> null
        is Result.Failure -> this.throwable
    }
}

fun <R, T : R> Result<T>.getOrElse(onFailure: (throwable: Throwable) -> R): R {
    return when(this) {
        is Result.Success -> this.value
        is Result.Failure -> onFailure(this.throwable)
    }
}

fun <R, T : R> Result<T>.recover(transform: (throwable: Throwable) -> R): Result<R> {
    return when(this) {
        is Result.Success -> this
        is Result.Failure -> getResult { transform(this.throwable) }
    }
}

fun <T, R> Result<T>.fold(onSuccess: (value: T) -> R, onFailure: (throwable: Throwable) -> R): R {
    return when(this) {
        is Result.Success -> onSuccess(this.value)
        is Result.Failure -> onFailure(this.throwable)
    }
}

fun <T, R> Result<T>.map(transform: (value: T) -> R): Result<R> {
    return when(this) {
        is Result.Success -> getResult { transform(this.value) }
        is Result.Failure -> this
    }
}