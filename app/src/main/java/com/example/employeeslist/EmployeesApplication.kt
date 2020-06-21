package com.example.employeeslist

import android.app.Application
import com.example.employeeslist.connector.DIConnector
import com.example.employeeslist.connector.DaggerDIConnector
import com.example.employeeslist.repo.apiservice.ApiCreatorConfig
import com.example.employeeslist.repo.apiservice.RetrofitModule

class EmployeesApplication: Application() {

    lateinit var component: DIConnector

    override fun onCreate() {
        super.onCreate()

        component = DaggerDIConnector
            .builder()
            .retrofitModule(retrofitModule())
            .build()
    }

    private fun retrofitModule() : RetrofitModule {
        return RetrofitModule(
            ApiCreatorConfig("http://dummy.restapiexample.com/")
        )
    }
}