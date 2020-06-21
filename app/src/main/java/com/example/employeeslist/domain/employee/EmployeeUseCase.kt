package com.example.employeeslist.domain.employee

import com.example.employeeslist.entity.employee.Employee
import io.reactivex.Single

interface EmployeeUseCase {
    fun getEmployees(): Single<List<Employee>>
}