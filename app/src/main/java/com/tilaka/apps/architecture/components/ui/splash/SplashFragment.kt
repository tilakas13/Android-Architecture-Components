package com.tilaka.apps.architecture.components.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.tilaka.apps.architecture.components.R
import com.tilaka.apps.architecture.components.base.BaseFragment
import com.tilaka.apps.architecture.components.common.AppConstants
import com.tilaka.apps.architecture.components.common.Logger

class SplashFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        showSupportBar(false)
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
            Logger.printMessage(AppConstants.LOG_TAG, "Splash time out")
            findNavController().navigate(R.id.action_splashFragment_to_genreFragment)
        }, AppConstants.SPLASH_TIMEOUT)
    }

}