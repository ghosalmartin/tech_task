package com.example.mgh01.techtask.utils

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.adapter.rxjava2.Result

object RxUtils {

    fun <T> networkTask(observable: Single<Result<T>>): Single<T> =
            observable
                    .subscribeOn(Schedulers.io())
                    .map { emitResponseBody(it) }

    private fun <T> emitResponse(result: Result<T>) =
            if (result.isError) {
                throw ApiException(0)
            } else {
                if (result.response()?.isSuccessful == false) {
                    val bytes = result.response()?.errorBody()?.bytes()
                    if (bytes != null) {
                        throw ApiException(result.response()?.code() ?: 0, String(bytes))
                    } else {
                        throw ApiException(result.response()?.code() ?: 0)
                    }
                } else {
                    result.response()
                }
            }

    private fun <T> emitResponseBody(result: Result<T>) = emitResponse(result)?.body()
}