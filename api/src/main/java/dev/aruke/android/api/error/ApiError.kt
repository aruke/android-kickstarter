package dev.aruke.android.api.error

sealed class ApiError(override val cause: Throwable?) : Throwable() {

    class NetworkError(cause: Throwable? = null) : ApiError(cause)

    class BadRequestError(cause: Throwable? = null) : ApiError(cause)

    class ServerError(cause: Throwable? = null) : ApiError(cause)

}