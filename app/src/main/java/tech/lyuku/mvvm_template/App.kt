package tech.lyuku.mvvm_template

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import tech.lyuku.mvvm_template.base.core.base.IApp

@HiltAndroidApp
class App :Application(), IApp {

    override fun getBaseUrl(): String {
        return BuildConfig.BASE_URL
    }

    override fun isDebug(): Boolean {
        return BuildConfig.DEBUG
    }

}