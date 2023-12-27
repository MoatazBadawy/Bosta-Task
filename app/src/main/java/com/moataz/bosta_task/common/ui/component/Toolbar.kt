package com.moataz.bosta_task.common.ui.component

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moataz.bosta_task.app.main.theme.Black
import com.moataz.bosta_task.app.main.theme.WhiteLight

@Composable
fun Toolbar(
    title: String,
) {
    TopAppBar(
        backgroundColor = WhiteLight,
        elevation = 0.dp,
        modifier = Modifier
            .height(60.dp)
            .shadow(elevation = 0.dp),
        title = {
            Text(
                text = title,
                modifier = Modifier.padding(end = 16.dp),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    color = Black,
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        },
    )
}