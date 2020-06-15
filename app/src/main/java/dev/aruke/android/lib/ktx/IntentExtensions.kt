package dev.aruke.android.lib.ktx

import android.content.Intent
import android.os.Parcelable

fun <T : Parcelable> Intent?.requireParcelable(key: String): T {
    this ?: throw IllegalStateException("Bundle must not be null")
    return getParcelableExtra<T>(key)
        ?: throw IllegalStateException("Bundle must contain Parcelable subclass with key '$key'")
}