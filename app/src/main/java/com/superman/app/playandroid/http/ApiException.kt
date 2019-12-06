package com.superman.app.playandroid.http

data class ApiException(var errCode: Int, var errMsg: String) : Exception()