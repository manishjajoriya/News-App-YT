package com.manishjajoriya.kabar.data.remote.dto

import com.manishjajoriya.kabar.domain.model.Article

data class NewsResponse(val articles: List<Article>, val status: String, val totalResults: Int)
