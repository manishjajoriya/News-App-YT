package com.manishjajoriya.kabar.domain.usecases

import com.manishjajoriya.kabar.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(private val localUserManager: LocalUserManager) {

  suspend fun invoke(): Flow<Boolean> {
    return localUserManager.readAppEntry()
  }
}
