package dev.aruke.android.config

/**
 * Holds application wide configuration, read from koin.properties in assets.
 */
data class Config(
    val environment: Environment,
    val baseAPiUrl: String,
    val httpLoggingEnabled: Boolean
)