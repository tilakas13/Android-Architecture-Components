package com.tilaka.apps.architecture.components.common

import android.util.Log

class Logger {

    companion object{
        fun printMessage(tagName: String, message: String) {
            Log.d(tagName, "printMessage: ")
        }
    }


}