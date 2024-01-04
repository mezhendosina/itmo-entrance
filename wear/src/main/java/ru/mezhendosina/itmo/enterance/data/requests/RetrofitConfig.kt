package ru.mezhendosina.itmo.enterance.data.requests

import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RetrofitConfig @Inject constructor(
    val retrofit: Retrofit
)