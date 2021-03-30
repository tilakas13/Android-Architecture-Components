package com.tilaka.apps.architecture.components.base

import androidx.appcompat.app.AppCompatActivity
import com.tilaka.apps.architecture.components.common.AppConstants
import com.tilaka.apps.architecture.components.common.Logger
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
open class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var logger: Logger

    override fun onDestroy() {
        logger.printMessage(AppConstants.LOG_TAG, "BaseActivity onDestroy")
        super.onDestroy()
    }
}