package com.moataz.bosta_task.common.component

import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
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
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    color = Black,
                ),
            )
        },
    )
}