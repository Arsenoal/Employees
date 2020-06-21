package com.example.employeeslist.repo.employee

import com.example.employeeslist.repo.BaseResponse
import com.example.employeeslist.repo.employee.model.Employee
import io.reactivex.Single
import retrofit2.http.GET

interface EmployeeRestService {
    @GET("api/v1/employees")
    fun getEmployees(): Single<BaseResponse<List<Employee>>>
}