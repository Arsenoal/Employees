package com.example.employeeslist.repo

import com.google.gson.annotations.SerializedName

data class BaseResponse<T> (
    @SerializedName("status") val status: String,
    @SerializedName("data") val response: T
)