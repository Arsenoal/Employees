package com.example.employeeslist.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.employeeslist.R
import com.example.employeeslist.entity.employee.Employee

class EmployeeRecyclerAdapter(
    private val employees: MutableList<Employee> = mutableListOf()
): RecyclerView.Adapter<EmployeeRecyclerAdapter.EmployeeViewHolder>() {

    private lateinit var layoutInflater: LayoutInflater

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)

        layoutInflater = LayoutInflater.from(recyclerView.context)
    }

    class EmployeeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val employeeImageView = itemView.findViewById<AppCompatImageView>(R.id.employeeImageView)
        private val employeeNameTextView = itemView.findViewById<AppCompatTextView>(R.id.employeeNameTextView)
        private val employeeAgeTextView = itemView.findViewById<AppCompatTextView>(R.id.employeeAgeTextView)

        fun bind(employee: Employee) {
            if(employee.profileImage.isNotBlank()) {
                Glide.with(itemView.context)
                    .load(employee.profileImage)
                    .into(employeeImageView)
            }

            employeeNameTextView.setText("name: ${employee.employeeName}")
            employeeAgeTextView.setText("age: ${employee.employeeAge}")
        }

    }

    fun addEmployees(items: List<Employee>) {
        val index = employees.size
        employees.addAll(items)
        notifyItemRangeInserted(index, items.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        return EmployeeViewHolder(layoutInflater.inflate(R.layout.employee_recycler_item, parent, false))
    }

    override fun getItemCount() = employees.size

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        holder.bind(employee = employees[position])
    }
}
