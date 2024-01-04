package ru.mezhendosina.itmo.enterance.data

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.g0dkar.qrcode.QRCode
import javax.inject.Inject
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class QrCodeGenerator @Inject constructor() {

    fun generate(input: String): ImageBitmap {
        val qr = QRCode(input).render().getBytes()

        return BitmapFactory.decodeByteArray(qr, 0, qr.size).asImageBitmap()
    }
}