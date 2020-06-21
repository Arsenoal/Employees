package com.example.employeeslist.domain.employee

import com.example.employeeslist.repo.employee.EmployeeRepo

class EmployeeFromRest(private val employeeRepo: EmployeeRepo): EmployeeUseCase {
    override fun getEmployees() = with(employeeRepo) {
        getEmployees()
    }
}