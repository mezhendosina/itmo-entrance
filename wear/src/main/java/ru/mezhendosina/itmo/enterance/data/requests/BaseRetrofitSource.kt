package ru.mezhendosina.itmo.enterance.data.requests

import android.util.Log

open class BaseRetrofitSource(
    private val config: RetrofitConfig
) {

    val retrofit = config.retrofit

    suspend fun <T> wrapRetrofitRequest(block: suspend () -> T): T {
        return try {
            block()
        } catch (e: Exception) {
            Log.e(null, e.stackTraceToString())
            throw e
        }
    }
}