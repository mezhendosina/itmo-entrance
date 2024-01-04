package ru.mezhendosina.itmo.enterance.presentation.qr

import android.content.Context
import android.graphics.Bitmap
import androidx.compose.ui.graphics.ImageBitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.mezhendosina.itmo.enterance.data.SettingsRepo
import ru.mezhendosina.itmo.enterance.data.requests.QrRepo
import ru.mezhendosina.itmo.enterance.data.requests.RetrofitConfig
import javax.inject.Inject

@HiltViewModel
class QrViewModel @Inject constructor(
    val qrRepo: QrRepo,
    val settingsRepo: SettingsRepo
) : ViewModel() {

    private val _qr = MutableStateFlow<ImageBitmap?>(null)
    private val _state = MutableStateFlow(State.Loading)
    val qr: StateFlow<ImageBitmap?> = _qr.asStateFlow()
    val state: StateFlow<State> = _state.asStateFlow()


    init {
        viewModelScope.launch {
            getQr()
        }
    }

    fun reloadQr() {
        viewModelScope.launch {
            getQr()
        }
    }

    suspend fun getQr(): ImageBitmap? {
        _state.value = State.Loading
        try {
            val sso = settingsRepo.getSSO() ?: throw Exception()
            val getQR = qrRepo.getQr(sso)
            _qr.value = getQR
            _state.value = State.Loaded
        } catch (e: Exception) {
            _state.value = State.Error
        }
        return null
    }

}