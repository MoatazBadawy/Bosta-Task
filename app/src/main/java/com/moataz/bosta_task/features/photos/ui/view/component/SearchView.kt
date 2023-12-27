package com.moataz.bosta_task.features.photos.ui.view.component

import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.moataz.bosta_task.app.main.theme.Black
import com.moataz.bosta_task.app.main.theme.MainColor
import com.moataz.bosta_task.features.photos.ui.viewmodel.PhotosViewModel

@Composable
fun SearchView(viewModel: PhotosViewModel) {
    val searchQuery by viewModel.searchQuery.collectAsState()
    val view = LocalView.current
    val imm =
        LocalContext.current.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        value = searchQuery,
        onValueChange = { newValue ->
            viewModel.setSearchQuery(newValue)
            viewModel.searchPhotosByTitle()
        },
        label = { Text("Search in Images") },
        singleLine = true,
        maxLines = 1,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = {
            viewModel.searchPhotosByTitle()
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }),
        leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MainColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            cursorColor = Black,
            focusedLabelColor = Color.Gray
        ),
    )
}