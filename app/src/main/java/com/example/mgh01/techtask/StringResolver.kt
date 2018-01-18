package com.example.mgh01.techtask

import android.support.annotation.StringRes

interface StringResolver {
    fun getStringRes(@StringRes resId: Int, vararg formatArgs: Any?): String
}