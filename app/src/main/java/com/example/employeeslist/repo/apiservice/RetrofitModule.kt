package com.example.employeeslist.repo.apiservice

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

data class ApiCreatorConfig(val baseUrl: String)

@Module
class RetrofitModule(private val config: ApiCreatorConfig) {

    @Provides
    @Singleton
    fun provideRetrofit() = with(Retrofit.Builder()) {
        addConverterFactory(GsonConverterFactory.create())
        addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        client(OkHttpClient())
        build()
    }
}