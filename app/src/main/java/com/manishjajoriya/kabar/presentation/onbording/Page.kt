package com.manishjajoriya.kabar.presentation.onbording

import androidx.annotation.DrawableRes
import com.manishjajoriya.kabar.R

data class Page(val title: String, val description: String, @DrawableRes val image: Int)

val pages =
  listOf(
    Page(
      title = "Your Daily News, Reimagined",
      description =
        "Welcome! Get access to breaking news and top stories from around the globe, all in one place.",
      image = R.drawable.onboarding1,
    ),
    Page(
      title = "News That Matters, Just for You",
      description =
        "Tell us your interests, and we'll build a news feed uniquely tailored to you. Follow topics you care about.",
      image = R.drawable.onboarding2,
    ),
    Page(
      title = "Stay Informed, Effortlessly",
      description =
        "Dive into a clean reading experience and explore a wide range of topics and reliable sources. Staying informed has never been easier.",
      image = R.drawable.onboarding3,
    ),
  )
