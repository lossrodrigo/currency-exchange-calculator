package com.currencyexchangeapp.currencyexchangecalculator.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "http://data.fixer.io/api/"

//moshi
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

//retrofit object
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

//retrofit service
interface CurrenciesApiService {

    @GET("latest?access_key=74f98b71b4f9d71b6e4658273ca30644&format=1")
    suspend fun getCurrenciesQuotations(): CurrencyList
}

//retrofit service object
object CurrenciesQuotationsApi {
    val retrofitService: CurrenciesApiService by lazy { retrofit.create(CurrenciesApiService::class.java) }
}