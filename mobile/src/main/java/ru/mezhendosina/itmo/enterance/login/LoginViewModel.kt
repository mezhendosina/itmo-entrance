package ru.mezhendosina.itmo.enterance.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginViewModel : ViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    private val loading: LiveData<Boolean> = _loading


    suspend fun login(login: String, password: String) {
        withContext(Dispatchers.Main) {
            _loading.value = true
        }
        try {
            TODO()
        } finally {
            withContext(Dispatchers.Main) {
                _loading.value = false
            }
        }
    }
}