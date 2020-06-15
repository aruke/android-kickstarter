package dev.aruke.android.lib.ktx

import android.os.Bundle
import android.os.Parcelable

fun <T : Parcelable> Bundle?.requireParcelable(key: String): T {
    this ?: throw IllegalStateException("Bundle must not be null")
    return getParcelable<T>(key)
        ?: throw IllegalStateException("Bundle must contain Parcelable subclass with key '$key'")
}