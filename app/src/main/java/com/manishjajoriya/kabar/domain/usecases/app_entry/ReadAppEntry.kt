package com.manishjajoriya.kabar.domain.usecases.app_entry

import com.manishjajoriya.kabar.domain.manager.LocalUserManager
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class ReadAppEntry @Inject constructor(private val localUserManager: LocalUserManager) {

  operator fun invoke(): Flow<Boolean> {
    return localUserManager.readAppEntry()
  }
}
