package dev.aruke.android.lib

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("app:srcUrl")
fun ImageView.srcUrl(imageUrl: String?) {
    Picasso.get().load(imageUrl).into(this)
}

@BindingAdapter("app:goneIfTrue")
fun View.goneIfTrue(shouldHide: Boolean?) {
    visibility = if (shouldHide == true) View.GONE else View.VISIBLE
}

@BindingAdapter("app:hideIfTrue")
fun View.hideIfTrue(shouldHide: Boolean?) {
    visibility = if (shouldHide == true) View.INVISIBLE else View.VISIBLE
}