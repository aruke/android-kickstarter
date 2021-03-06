package dev.aruke.android.api

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import dev.aruke.android.api.interceptor.ErrorInterceptor
import dev.aruke.android.api.interceptor.LoggingInterceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiModule {

    operator fun invoke(baseApiUrl: String, enableHttpLogging: Boolean) = module {
        single {
            apiService(baseApiUrl, enableHttpLogging)
        }
    }

    private fun apiService(
        apiUrl: String,
        enableHttpLogging: Boolean
    ): ApiService {
        // Converter
        val jsonConverterFactory = GsonConverterFactory.create(
            Gson().newBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()
        )

        // HTTP Client
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(LoggingInterceptor(enableHttpLogging))
            .addInterceptor(ErrorInterceptor())
            .build()

        return Retrofit.Builder()
            .baseUrl(apiUrl)
            .client(okHttpClient)
            .addConverterFactory(jsonConverterFactory)
            .build()
            .create(ApiService::class.java)
    }
}