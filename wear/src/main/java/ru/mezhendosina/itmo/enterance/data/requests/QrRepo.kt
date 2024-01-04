package ru.mezhendosina.itmo.enterance.data.requests

import androidx.compose.ui.graphics.ImageBitmap
import ru.mezhendosina.itmo.enterance.data.QrCodeGenerator
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class QrRepo @Inject constructor(
    config: RetrofitConfig,
    private val qrCodeGenerator: QrCodeGenerator
) : BaseRetrofitSource(config) {


    private val qrApi = retrofit.create(QrApi::class.java)

    suspend fun getQr(sso: String): ImageBitmap = wrapRetrofitRequest {
//        try {
//            qrApi.getQr("REMEMBER_SSO=$sso;")
//        } catch (e: Exception) {
//        }
        val hexcode = qrApi.getQr("ORA_WWV_RAC_INSTANCE=2; cf_session=NJCRVNPF; REMEMBER_SSO=DC074336ACF661B24BF8D31B9F916DDF:CBA02FCC4E09554438A597347E63A1788381FB06ED5A34D6F9974CDDB69CF044F5EAE01D8D1A810CE1C596E3A6FC1A29; ISU_AP_COOKIE=ORA_WWV-tcAwsfPwBTdAPC34TMWGV8EJ; ISU_LIB_SID=ORA_WWV-tcAwsfPwBTdAPC34TMWGV8EJ")
        qrCodeGenerator.generate(hexcode.hexcode)
    }

}