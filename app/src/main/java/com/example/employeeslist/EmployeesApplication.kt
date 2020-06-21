package com.example.employeeslist

import android.app.Application
import android.content.Context
import com.example.employeeslist.connector.DIConnector
import com.example.employeeslist.connector.DaggerDIConnector
import com.example.employeeslist.connector.EmployeeModule
import com.example.employeeslist.repo.apiservice.ApiCreatorConfig
import com.example.employeeslist.repo.apiservice.RetrofitModule
import java.security.NoSuchAlgorithmException
import javax.net.ssl.SSLContext

class EmployeesApplication: Application() {

    lateinit var component: DIConnector

    override fun onCreate() {
        super.onCreate()

        component = DaggerDIConnector
            .builder()
            .retrofitModule(retrofitModule())
            .employeeModule(EmployeeModule())
            .build()
    }

    private fun retrofitModule() : RetrofitModule {
        return RetrofitModule(
            ApiCreatorConfig("http://dummy.restapiexample.com/")
        )
    }
}