package com.manishjajoriya.kabar.domain.usecases

import com.manishjajoriya.kabar.domain.manager.LocalUserManager

class SaveAppEntry(private val localUserManager: LocalUserManager) {

  suspend fun invoke() {
    localUserManager.saveAppEntry()
  }
}
