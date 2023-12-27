package com.moataz.bosta_task.features.profile.ui.view.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moataz.bosta_task.app.main.theme.Black
import com.moataz.bosta_task.app.main.theme.MainColor
import com.moataz.bosta_task.app.main.theme.White50
import com.moataz.bosta_task.features.profile.ui.viewmodel.model.album.AlbumUI

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AlbumItem(
    album: AlbumUI,
    onAlbumClicked: (Long, String) -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        shape = RoundedCornerShape(0.dp),
        backgroundColor = White50,
        elevation = 0.dp,
        onClick = {
            onAlbumClicked(album.id, album.title)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Divider(
                color = MainColor,
                thickness = 1.dp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = album.title,
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Black,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
        }
    }
}