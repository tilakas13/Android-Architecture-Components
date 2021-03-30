package com.tilaka.apps.architecture.components.common

import android.util.Log
import com.tilaka.apps.architecture.components.BuildConfig
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Logger @Inject constructor() {

    fun printMessage(tagName: String, message: String) {
        if (BuildConfig.DEBUG) {
            Log.d(tagName, message)
        }
    }
}