package ru.mezhendosina.itmo.enterance.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.first
import javax.inject.Inject


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

@Module
@InstallIn(SingletonComponent::class)
class SettingsRepo @Inject  constructor(
    @ApplicationContext private val context: Context
) {

    private val sso = stringPreferencesKey("sso")

    suspend fun getSSO(): String? = context.dataStore.data.first()[sso]

    suspend fun setSSO(sso: String) =
        context.dataStore.edit { it[this.sso] = sso }

}



