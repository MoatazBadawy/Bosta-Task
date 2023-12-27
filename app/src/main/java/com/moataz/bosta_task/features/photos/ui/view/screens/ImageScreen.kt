package com.moataz.bosta_task.features.photos.ui.view.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.moataz.bosta_task.R
import com.moataz.bosta_task.app.main.theme.Black
import com.moataz.bosta_task.app.main.theme.White50
import com.moataz.bosta_task.app.main.theme.WhiteLight
import com.moataz.bosta_task.features.photos.ui.view.utils.shareImage
import com.moataz.bosta_task.features.photos.ui.viewmodel.ImageViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ImageScreen(
    navController: NavController,
    viewModel: ImageViewModel = hiltViewModel()
) {
    val image by viewModel.imageUrl.collectAsState()
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White50)
    ) {
        when {
            image.isNotEmpty() -> ImageContent(
                image = image,
                onBackClicked = { navController.popBackStack() }
            )
        }

        FloatingActionButton(
            onClick = { shareImage(context, image) },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp),
            backgroundColor = Black,
            contentColor = WhiteLight,
        ) {
            Icon(Icons.Filled.Share, contentDescription = null)
        }
    }
}

@Composable
fun ImageContent(
    image: String,
    onBackClicked: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = 8.dp),
        ) {
            IconButton(
                onClick = { onBackClicked() },
            ) {
                Icon(Icons.Filled.ArrowBack, contentDescription = null)
            }
            Text(
                text = "Preview",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Black,
                ),
            )
        }

        Image(
            painter = rememberImagePainter(
                data = image,
                builder = {
                    placeholder(drawableResId = R.drawable.placeholder)
                }
            ),
            contentDescription = null,
            modifier = Modifier
                .matchParentSize()
                .align(Alignment.Center)
        )
    }
}