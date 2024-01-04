package ru.mezhendosina.itmo.enterance.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.CookieJar
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.mezhendosina.itmo.enterance.data.requests.QrApi
import java.net.CookieManager
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class BaseRetrofit {

    @Provides
    fun provideBaseUrl(): String = "https://isu.ifmo.ru/"


    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: Interceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()


    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String, okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .baseUrl(baseUrl)
        .build()


    @Provides
    @Singleton
    fun createLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }
}