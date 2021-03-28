package com.tilaka.apps.architecture.components.base

import androidx.appcompat.app.AppCompatActivity
import com.tilaka.apps.architecture.components.common.AppConstants
import com.tilaka.apps.architecture.components.common.Logger


open class BaseActivity : AppCompatActivity() {


    override fun onDestroy() {
        Logger.printMessage(AppConstants.LOG_TAG, "BaseActivity onDestroy")
        super.onDestroy()
    }
}