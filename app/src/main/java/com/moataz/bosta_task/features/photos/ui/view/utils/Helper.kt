package com.moataz.bosta_task.features.photos.ui.view.utils

import android.content.Context
import android.content.Intent

fun shareImage(context: Context, imageUrl: String) {
    val shareText = "Check out this exciting photo from Bosta! \uD83E\uDD29 \n $imageUrl"
    val sendIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, shareText)
        type = "text/plain"
    }

    val shareIntent = Intent.createChooser(sendIntent, null)
    context.startActivity(shareIntent)
}