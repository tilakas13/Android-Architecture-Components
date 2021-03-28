package com.tilaka.apps.architecture.components.ui

import android.os.Bundle
import com.tilaka.apps.architecture.components.R
import com.tilaka.apps.architecture.components.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}