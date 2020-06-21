package com.example.employeeslist.presentation

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.employeeslist.R
import com.example.employeeslist.entity.employee.Employee
import com.example.employeeslist.presentation.base.BaseActivity
import com.example.employeeslist.presentation.employee.EmployeePresenter
import com.example.employeeslist.presentation.employee.EmployeeViewState

class MainActivity : BaseActivity(), EmployeeViewState {

    @InjectPresenter
    lateinit var employeePresenter: EmployeePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        employeePresenter.loadEmployees()
    }



    override fun onLoadEmployees(employees: List<Employee>) {
        print(employees.toString())
    }

    @ProvidePresenter
    fun providePresenter(): EmployeePresenter {
        return EmployeePresenter(application)
    }
}
