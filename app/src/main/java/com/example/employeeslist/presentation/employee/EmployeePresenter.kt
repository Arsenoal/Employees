package com.example.employeeslist.presentation.employee

import android.content.Context
import com.arellomobile.mvp.InjectViewState
import com.example.employeeslist.EmployeesApplication
import com.example.employeeslist.domain.employee.EmployeeUseCase
import com.example.employeeslist.presentation.base.BasePresenter
import javax.inject.Inject

@InjectViewState
class EmployeePresenter(
    context: Context
): BasePresenter<EmployeeViewState>() {

    @Inject lateinit var employeeUseCase: EmployeeUseCase

    init {
        (context.applicationContext as EmployeesApplication).component.inject(this)
    }

    fun loadEmployees() {
        execute(employeeUseCase.getEmployees()) { employees ->
            viewState.onLoadEmployees(employees)
        }
    }
}