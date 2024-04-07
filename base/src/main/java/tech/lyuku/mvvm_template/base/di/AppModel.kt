package tech.lyuku.mvvm_template.base.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import retrofit2.Retrofit
import tech.lyuku.mvvm_template.base.core.db.IRealmProvider
import tech.lyuku.mvvm_template.base.core.db.RealmProvider
import tech.lyuku.mvvm_template.base.core.network.RetrofitBuilder
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModel {

    @Singleton
    @Provides
    fun retrofit(@ApplicationContext appContext: Context): Retrofit =
        RetrofitBuilder.build(appContext = appContext)

    @Singleton
    @Provides
    fun provideRealmProvider(
        @ApplicationContext appContext: Context,
        @RealmDispatcher realmDispatcher: CoroutineDispatcher
    ): IRealmProvider =
        RealmProvider(appContext, realmDispatcher)

}
