package com.manishjajoriya.kabar.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.manishjajoriya.kabar.domain.manager.LocalUserManager
import com.manishjajoriya.kabar.util.Constants
import com.manishjajoriya.kabar.util.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserManagerImpl(private val context: Context) : LocalUserManager {
  override suspend fun saveAppEntry() {
    context.dataStore.edit { setting -> setting[PreferencesKey.APP_ENTRY] = true }
  }

  override fun readAppEntry(): Flow<Boolean> {
    return context.dataStore.data.map { preferences ->
      preferences[PreferencesKey.APP_ENTRY] == true
    }
  }
}

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)

private object PreferencesKey {
  val APP_ENTRY = booleanPreferencesKey(Constants.APP_ENTRY)
}
