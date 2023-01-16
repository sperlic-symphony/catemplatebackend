package com.symphony.catemplate.catemplate.repository.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.symphony.catemplate.catemplate.repository.model.Pollution
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import org.springframework.stereotype.Component
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Component
class HttpClientImpl {

    private final val retrofit = Retrofit.Builder()
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl("http://api.airvisual.com/v2/")
        .client(
            OkHttpClient.Builder()
                .addInterceptor(ApiInterceptor())
                .build()
        )
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder()
                    .add(KotlinJsonAdapterFactory())
                    .build()
            )
        )
        .build()

    private val apiServices = retrofit.create(ApiServices::class.java)

    suspend fun getPollution(lat: Double, lon: Double): Pollution {
        val a = apiServices.getPollution(lat, lon).body()!!
        val pollutionData = a.data.current.pollution
        return Pollution(pollutionData.aqius, pollutionData.mainus)
    }
}

class ApiInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val url =
            chain.request().url.newBuilder()
                .addQueryParameter("key", "d50497d4-9da1-4047-bc9a-d8194639650f").build()

        val request = chain.request().newBuilder().url(url).build()
        return chain.proceed(request)
    }

    //http://api.airvisual.com/v2/nearest_city?lat=45.35&lon=19.23&key=d50497d4-9da1-4047-bc9a-d8194639650f

}