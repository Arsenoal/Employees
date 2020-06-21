package com.example.employeeslist.repo.employee

import com.example.employeeslist.repo.employee.employee.EmployeeRestService
import com.example.employeeslist.repo.employee.model.toEntity
import javax.inject.Inject

class EmployeeRestRepo
    @Inject constructor(private val employeeRestService: EmployeeRestService): EmployeeRepo {
    override fun getEmployees() = with(employeeRestService) {
        getEmployees().map { list -> list.map { it.toEntity() } }
    }
}