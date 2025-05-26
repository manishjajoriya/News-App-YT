package com.manishjajoriya.kabar.domain.usecases

import com.manishjajoriya.kabar.domain.manager.LocalUserManager
import javax.inject.Inject

class SaveAppEntry @Inject constructor(private val localUserManager: LocalUserManager) {

  suspend fun invoke() {
    localUserManager.saveAppEntry()
  }
}
