package com.example.employeeslist.repo.employee.model

import com.google.gson.annotations.SerializedName

data class Employee(
    @SerializedName("id") val id: String,
    @SerializedName("employee_name") val employeeName: String,
    @SerializedName("employee_salary") val employeeSalary: String,
    @SerializedName("employee_age") val employeeAge: String,
    @SerializedName("profile_image") val profileImage: String
)

fun Employee.toEntity() : com.example.employeeslist.entity.employee.Employee {
    return com.example.employeeslist.entity.employee.Employee(
        id = id,
        employeeName = employeeName,
        employeeSalary = employeeSalary,
        employeeAge = employeeAge,
        profileImage = profileImage
    )
}