package dev.aruke.android.api.interceptor

import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber

object LoggingInterceptor {

    operator fun invoke(enableFullLogging: Boolean): HttpLoggingInterceptor {
        // Default Logger prints on level Debug, we want it on Verbose
        val verboseLogger = object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Timber.v(message)
            }
        }

        return HttpLoggingInterceptor(verboseLogger).apply {
            level = if (enableFullLogging)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE
        }
    }
}