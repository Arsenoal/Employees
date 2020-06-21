package com.example.employeeslist.repo.employee

import com.example.employeeslist.entity.employee.Employee
import io.reactivex.Single

interface EmployeeRepo {
    fun getEmployees(): Single<List<Employee>>
}