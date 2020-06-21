package com.example.employeeslist.connector

import com.example.employeeslist.domain.employee.EmployeeFromRest
import com.example.employeeslist.domain.employee.EmployeeUseCase
import com.example.employeeslist.repo.employee.EmployeeRepo
import com.example.employeeslist.repo.employee.EmployeeRestRepo
import com.example.employeeslist.repo.employee.EmployeeRestService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class EmployeeModule {

    @Provides
    fun getEmployeeRestService(retrofit: Retrofit): EmployeeRestService {
        return retrofit.create(EmployeeRestService::class.java)
    }

    @Provides
    fun getEmployeeRepo(service: EmployeeRestService): EmployeeRepo {
        return EmployeeRestRepo(service)
    }

    @Provides
    fun getEmployeeUseCase(employeeRepo: EmployeeRepo): EmployeeUseCase {
        return EmployeeFromRest(employeeRepo)
    }
}