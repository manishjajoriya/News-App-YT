package com.manishjajoriya.kabar.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.manishjajoriya.kabar.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val newsUseCases: NewsUseCases) : ViewModel() {

  val news =
    newsUseCases
      .getNews(sources = listOf("bbc-news", "bbc-news", "al-jazeera-english"))
      .cachedIn(viewModelScope)
}
