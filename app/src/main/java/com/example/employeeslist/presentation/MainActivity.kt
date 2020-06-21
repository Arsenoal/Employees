package com.example.employeeslist.presentation

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.employeeslist.R
import com.example.employeeslist.entity.employee.Employee
import com.example.employeeslist.presentation.adapter.EmployeeRecyclerAdapter
import com.example.employeeslist.presentation.base.BaseActivity
import com.example.employeeslist.presentation.employee.EmployeePresenter
import com.example.employeeslist.presentation.employee.EmployeeViewState
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), EmployeeViewState {

    @InjectPresenter
    lateinit var employeePresenter: EmployeePresenter

    private val adapter: EmployeeRecyclerAdapter = EmployeeRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupUi()

        employeePresenter.loadEmployees()
    }

    private fun setupUi() {
        employeesListView.adapter = adapter
        employeesListView.layoutManager = LinearLayoutManager(this)
    }

    override fun onLoadEmployees(employees: List<Employee>) {
        adapter.addEmployees(employees)
    }

    @ProvidePresenter
    fun providePresenter(): EmployeePresenter {
        return EmployeePresenter(application)
    }
}
