package dev.aruke.android.api.interceptor

import dev.aruke.android.api.error.ApiError
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import timber.log.Timber

internal class ErrorInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val response = chain.proceed(request)
        when (response.code) {
            400 -> {
                val apiError =
                    ApiError.BadRequestError()
                Timber.e(apiError, "HttpError 400")
                throw apiError
            }
            500 -> {
                val apiError = ApiError.ServerError()
                Timber.e(apiError, "HttpError 500")
                throw apiError
            }
        }

        return response
    }
}