package com.example.employeeslist.presentation

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.employeeslist.EmployeesApplication
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

        (application as EmployeesApplication).component.inject(this)

        employeePresenter.loadEmployees()
    }



    override fun onLoadEmployees(employees: List<Employee>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
