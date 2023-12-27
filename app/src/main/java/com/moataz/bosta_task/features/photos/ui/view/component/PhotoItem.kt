package com.moataz.bosta_task.features.photos.ui.view.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.rememberImagePainter
import com.moataz.bosta_task.R
import com.moataz.bosta_task.features.photos.ui.viewmodel.model.PhotoUI

@Composable
fun PhotoItem(
    photo: PhotoUI,
    onImageClicked: (String) -> Unit
) {
    val painter = rememberImagePainter(
        data = photo.url,
        builder = {
            placeholder(drawableResId = R.drawable.placeholder)
        }
    )

    Image(
        painter = painter,
        contentDescription = null,
        modifier = Modifier
            .aspectRatio(1f)
            .clickable(
                onClick = {
                    onImageClicked(photo.url)
                }
            )
    )
}