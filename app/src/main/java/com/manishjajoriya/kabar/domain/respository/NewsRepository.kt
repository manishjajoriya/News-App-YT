package com.manishjajoriya.kabar.domain.respository

import androidx.paging.PagingData
import com.manishjajoriya.kabar.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

  fun getNews(sources: List<String>): Flow<PagingData<Article>>
}
