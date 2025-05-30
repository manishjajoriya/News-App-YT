package com.manishjajoriya.kabar.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.manishjajoriya.kabar.data.remote.NewsApi
import com.manishjajoriya.kabar.data.remote.NewsPagingSource
import com.manishjajoriya.kabar.domain.model.Article
import com.manishjajoriya.kabar.domain.respository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(private val newsApi: NewsApi) : NewsRepository {
  override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
    return Pager(
        config = PagingConfig(pageSize = 10),
        pagingSourceFactory = {
          NewsPagingSource(newsApi = newsApi, source = sources.joinToString(separator = ","))
        },
      )
      .flow
  }
}
