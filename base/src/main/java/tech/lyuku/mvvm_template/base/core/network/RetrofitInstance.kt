package tech.lyuku.mvvm_template.base.core.network

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import tech.lyuku.mvvm_template.base.core.base.IApp
import java.util.concurrent.TimeUnit

object RetrofitBuilder {

    fun build(appContext: Context): Retrofit {
        if (appContext !is IApp) {
            throw Exception("app must implements IApp")
        }
        return Retrofit.Builder()
            .baseUrl(appContext.getBaseUrl())
            .callFactory(okHttpCallFactory(appContext.isDebug()))
            .addConverterFactory(MoshiConverterFactory.create(createMoshi()))
            .build()
    }

    private fun createMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    private fun okHttpCallFactory(isDebug: Boolean): Call.Factory = OkHttpClient.Builder()
        .connectTimeout(3, TimeUnit.SECONDS)
        .writeTimeout(5, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .addInterceptor(
            HttpLoggingInterceptor()
                .apply {
                    if (isDebug) {
                        setLevel(HttpLoggingInterceptor.Level.BODY)
                    }
                },
        )
        .build()
}