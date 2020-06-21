package com.example.employeeslist.presentation.employee

import com.arellomobile.mvp.InjectViewState
import com.example.employeeslist.presentation.base.BasePresenter

@InjectViewState
class EmployeePresenter// @Inject constructor(private val employeeUseCase: EmployeeUseCase)
    : BasePresenter<EmployeeViewState>() {

    fun loadEmployees() {
        /*execute(employeeUseCase.getEmployees()) { employees ->
            viewState.onLoadEmployees(employees)
        }*/
    }
}