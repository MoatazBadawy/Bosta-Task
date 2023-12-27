package com.moataz.bosta_task.features.profile.ui.view.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moataz.bosta_task.app.main.theme.Black

@Composable
fun MyAlbumTitle(
    title: String,
) {
    Text(
        text = title,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 14.dp, bottom = 6.dp),
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Black,
        ),
    )
}