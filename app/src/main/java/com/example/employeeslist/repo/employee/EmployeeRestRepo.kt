package com.example.employeeslist.repo.employee

import com.example.employeeslist.repo.employee.model.toEntity

class EmployeeRestRepo(private val employeeRestService: EmployeeRestService): EmployeeRepo {
    override fun getEmployees() = with(employeeRestService) {
        getEmployees().map { list -> list.response.map { it.toEntity() } }
    }
}