package com.manishjajoriya.kabar.di

import android.app.Application
import com.manishjajoriya.kabar.data.manager.LocalUserManagerImpl
import com.manishjajoriya.kabar.data.remote.NewsApi
import com.manishjajoriya.kabar.data.repository.NewsRepositoryImpl
import com.manishjajoriya.kabar.domain.manager.LocalUserManager
import com.manishjajoriya.kabar.domain.respository.NewsRepository
import com.manishjajoriya.kabar.domain.usecases.app_entry.AppEntryUseCases
import com.manishjajoriya.kabar.domain.usecases.app_entry.ReadAppEntry
import com.manishjajoriya.kabar.domain.usecases.app_entry.SaveAppEntry
import com.manishjajoriya.kabar.domain.usecases.news.GetNews
import com.manishjajoriya.kabar.domain.usecases.news.NewsUseCases
import com.manishjajoriya.kabar.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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

  @Provides
  @Singleton
  fun provideNewsApi(): NewsApi =
    Retrofit.Builder()
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
      .create(NewsApi::class.java)

  @Provides
  @Singleton
  fun provideNewsRepository(newsApi: NewsApi): NewsRepository = NewsRepositoryImpl(newsApi)

  @Provides
  @Singleton
  fun provideNewsUseCases(newsRepository: NewsRepository): NewsUseCases {
    return NewsUseCases(getNews = GetNews(newsRepository))
  }
}
