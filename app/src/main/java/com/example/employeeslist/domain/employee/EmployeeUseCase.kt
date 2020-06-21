package com.example.employeeslist.domain.employee

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.employeeslist.entity.employee.Employee
import io.reactivex.Single

interface EmployeeUseCase {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun getEmployees(): Single<List<Employee>>
}