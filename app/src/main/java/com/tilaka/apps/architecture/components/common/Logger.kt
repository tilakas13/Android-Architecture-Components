package com.tilaka.apps.architecture.components.common

import android.util.Log
import com.tilaka.apps.architecture.components.BuildConfig

class Logger {

    companion object {
        fun printMessage(tagName: String, message: String) {
            if (BuildConfig.DEBUG) {
                Log.d(tagName, message)
            }
        }
    }


}