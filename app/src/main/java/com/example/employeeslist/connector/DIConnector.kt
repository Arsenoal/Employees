package com.example.employeeslist.connector

import com.example.employeeslist.presentation.MainActivity
import com.example.employeeslist.repo.apiservice.RetrofitModule
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class, EmployeeModule::class])
interface DIConnector {
    fun inject(mainActivity: MainActivity)
}