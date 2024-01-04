package ru.mezhendosina.itmo.enterance.presentation.qr

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.CircularProgressIndicator
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import com.google.android.horologist.tiles.images.toImageResource
import io.github.g0dkar.qrcode.QRCode
import kotlinx.coroutines.launch
import ru.mezhendosina.itmo.enterance.R
import ru.mezhendosina.itmo.enterance.data.QrCodeGenerator
import ru.mezhendosina.itmo.enterance.presentation.components.Qr
import ru.mezhendosina.itmo.enterance.presentation.theme.ItmoEntranceTheme

@Composable
fun QrScreen(
    viewModel: QrViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val state by viewModel.state.collectAsState()
    val qr by viewModel.qr.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(if (state == State.Loaded) Color.White else MaterialTheme.colors.background)
            .clickable { if (qr != null) viewModel.reloadQr() },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        when (state) {
            State.Loading -> {
                CircularProgressIndicator()
            }

            else -> {
                Qr(qr) {
                    coroutineScope.launch {
                        viewModel.getQr()
                    }
                }
            }
        }
    }
}

@Preview(device = "id:wearos_small_round", showBackground = true, showSystemUi = true)
@Composable
fun QrScreenPreview() {
    ItmoEntranceTheme {
//        QrScreen(QrCodeGenerator().generate("4D1DE628"), State.Error)
    }
}