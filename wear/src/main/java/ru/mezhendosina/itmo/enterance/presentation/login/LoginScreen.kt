package ru.mezhendosina.itmo.enterance.presentation.login

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Text
import androidx.wear.remote.interactions.RemoteActivityHelper
import com.google.android.gms.wearable.Wearable
import ru.mezhendosina.itmo.enterance.R
import ru.mezhendosina.itmo.enterance.presentation.theme.ItmoEntranceTheme


@Composable
fun LoginScreen(onLoginClickListener: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.welcome_to_itmo_enterance),
            textAlign = TextAlign.Center
        )
        Button(
            onClick = { onLoginClickListener.invoke() },
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(0.75f),
        ) {
            Text(text = stringResource(R.string.login))
        }
    }
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Preview(device = Devices.WEAR_OS_RECT, showSystemUi = true)
@Composable
fun PreviewLoginScreen() {
    ItmoEntranceTheme {
        LoginScreen({})
    }
}