/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package ru.mezhendosina.itmo.enterance.presentation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCompositionContext
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.net.toUri
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import androidx.wear.remote.interactions.RemoteActivityHelper
import com.google.android.gms.wearable.Wearable
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.mezhendosina.itmo.enterance.R
import ru.mezhendosina.itmo.enterance.data.SettingsRepo
import ru.mezhendosina.itmo.enterance.data.dataStore
import ru.mezhendosina.itmo.enterance.presentation.login.LoginScreen
import ru.mezhendosina.itmo.enterance.presentation.qr.QrScreen
import ru.mezhendosina.itmo.enterance.presentation.theme.ItmoEntranceTheme
import java.util.concurrent.Executor
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject lateinit var settingsRepo: SettingsRepo


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sso = intent.data?.getQueryParameter("sso")
        if (sso != null) {
            CoroutineScope(Dispatchers.IO).launch {
                settingsRepo.setSSO(sso)
            }
        }

        CoroutineScope(Dispatchers.Main).launch {
            val getSso = settingsRepo.getSSO()

            setContent {
                ItmoEntranceTheme {
                    if (getSso == null) {
                        LoginScreen {
                            val a = Uri.parse("itmoentrance://login")
                            RemoteActivityHelper(this@MainActivity).startRemoteActivity(
                                targetIntent = Intent(
                                    Intent.ACTION_VIEW,
                                ).addCategory(Intent.CATEGORY_BROWSABLE).setData(a),
                            )
                        }
                    } else {
                        QrScreen()
                    }
                }
            }
        }
    }
}