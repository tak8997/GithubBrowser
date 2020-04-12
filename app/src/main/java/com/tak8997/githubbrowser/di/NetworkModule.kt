package com.tak8997.githubbrowser.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.tak8997.githubbrowser.data.apiservice.GitHubApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule.ProvideModule::class])
internal class NetworkModule {

    companion object {
        const val BASE_URL = "https://api.github.com"
    }

    @Module
    class ProvideModule {

        @Singleton
        @Provides
        fun provideOkhttpClient(): OkHttpClient {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            return OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addNetworkInterceptor(StethoInterceptor())
                .build()
        }

        @Singleton
        @Provides
        fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .build()
        }

        @Singleton
        @Provides
        fun provideApiService(retrofit: Retrofit): GitHubApiService {
            return retrofit.create(GitHubApiService::class.java)
        }
    }
}