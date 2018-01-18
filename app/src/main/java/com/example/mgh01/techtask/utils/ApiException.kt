package com.example.mgh01.techtask.utils

class ApiException(val code: Int, val reason: String = "") : Throwable()