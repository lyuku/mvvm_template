package tech.lyuku.mvvm_template.base.di

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tech.lyuku.mvvm_template.base.core.base.PageState
import tech.lyuku.mvvm_template.base.core.base.PageStateObserver
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class PageStateModel {

    @Singleton
    @Provides
    fun provideEmptyPageStateObserver(): PageStateObserver {
        return object : PageStateObserver {
            override fun onPageStateChange(state: PageState) {
                // do nothing
                Log.d("PageStateModel", "onPageStateChange: $state")
            }
        }
    }
}