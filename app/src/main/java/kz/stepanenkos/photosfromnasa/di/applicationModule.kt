package kz.stepanenkos.photosfromnasa.di

import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

private const val BASE_URL = "https://api.nasa.gov/EPIC/api/"
private const val API_KEY = "dRse925lQxnnhBT9sHWrkRxUBnBheb966iSw68IE"

val applicationModule = module {
    single {
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.addInterceptor { interceptorChain ->
            val originalRequest = interceptorChain.request()

            val originalHttpUrl = originalRequest.url()

            val newUrl = originalHttpUrl.newBuilder()
                .addQueryParameter("api_key", API_KEY)
                .build()

            val requestBuilder = originalRequest.newBuilder().url(newUrl)

            val newRequest = requestBuilder.build()

            return@addInterceptor interceptorChain.proceed(newRequest)
        }
        okHttpClient.build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get())
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
    }
}