package com.manishjajoriya.kabar.domain.usecases.news

import androidx.paging.PagingData
import com.manishjajoriya.kabar.domain.model.Article
import com.manishjajoriya.kabar.domain.respository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(private val newsRepository: NewsRepository) {

  operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
    return newsRepository.getNews(sources)
  }
}
