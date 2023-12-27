package com.moataz.bosta_task.features.profile.ui.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moataz.bosta_task.app.main.theme.Black
import com.moataz.bosta_task.app.main.theme.White50
import com.moataz.bosta_task.features.profile.ui.viewmodel.model.user.AddressUI
import com.moataz.bosta_task.features.profile.ui.viewmodel.model.user.UserUI

@Composable
fun UserInformation(
    user: UserUI,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
    ) {
        Text(
            text = user.name,
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Black,
            ),
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "${user.address.street}, ${user.address.suite}, " +
                    "${user.address.city}, ${user.address.zipcode}",
            modifier = Modifier.fillMaxWidth(),
            maxLines = 2,
            style = TextStyle(
                fontSize = 15.sp,
                color = Black,
            ),
        )
    }
}

@Preview
@Composable
fun UserInformationPreview() {
    UserInformation(
        user = UserUI(
            id = 1,
            name = "Moataz Mohamed",
            username = "moataz",
            email = "lalla",
            address = AddressUI(
                street = "Kulas Light",
                suite = "Apt. 556",
                city = "Gwenborough",
                zipcode = "92998-3874",
            )
        )
    )
}