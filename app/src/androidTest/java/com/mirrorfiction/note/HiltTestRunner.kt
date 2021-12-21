package com.mirrorfiction.note

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner

/**
 * Create by Neil
 * on 2021/12/21.
 */
class HiltTestRunner : AndroidJUnitRunner() {

    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): Application {
        return super.newApplication(cl, HiltTestRunner::class.java.name, context)
    }
}