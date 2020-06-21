package com.example.employeeslist.presentation.employee

import com.arellomobile.mvp.MvpView
import com.example.employeeslist.entity.employee.Employee

interface EmployeeViewState: MvpView {
    fun onLoadEmployees(employees: List<Employee>)
}