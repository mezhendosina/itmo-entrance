package ru.mezhendosina.itmo.enterance.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.CompactButton
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import ru.mezhendosina.itmo.enterance.data.QrCodeGenerator
import ru.mezhendosina.itmo.enterance.presentation.theme.ItmoEnteranceTheme

@Composable
fun Qr(qr: ImageBitmap? = null, onRetryClickListener: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        if (qr != null) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(qr, contentDescription = "qr", modifier = Modifier.padding(32.dp))

            }
        } else {

            Column(
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Что-то пошло не так",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.fillMaxWidth(),
                )
                Button(
                    onClick = onRetryClickListener,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                ) {
                    Text(text = "Повторить попытку", style = MaterialTheme.typography.button)
                }
            }
        }
    }
}

@Preview(device = "id:wearos_small_round")
@Composable
fun PreviewQr() {
    ItmoEnteranceTheme {
        Qr {

        }
    }
}