package com.manishjajoriya.kabar.di

import android.app.Application
import com.manishjajoriya.kabar.data.manager.LocalUserManagerImpl
import com.manishjajoriya.kabar.domain.manager.LocalUserManager
import com.manishjajoriya.kabar.domain.usecases.app_entry.AppEntryUseCases
import com.manishjajoriya.kabar.domain.usecases.app_entry.ReadAppEntry
import com.manishjajoriya.kabar.domain.usecases.app_entry.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

  @Provides
  @Singleton
  fun provideLocalUserManger(application: Application): LocalUserManager =
    LocalUserManagerImpl(application)

  @Provides
  @Singleton
  fun provideAppEntryUseCases(localUserManager: LocalUserManager) =
    AppEntryUseCases(
      readAppEntry = ReadAppEntry(localUserManager),
      saveAppEntry = SaveAppEntry(localUserManager),
    )
}
