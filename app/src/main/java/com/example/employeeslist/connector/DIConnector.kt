package com.example.employeeslist.connector

import com.example.employeeslist.presentation.employee.EmployeePresenter
import com.example.employeeslist.repo.apiservice.RetrofitModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class, EmployeeModule::class])
interface DIConnector {
    fun inject(mainActivity: EmployeePresenter)
}