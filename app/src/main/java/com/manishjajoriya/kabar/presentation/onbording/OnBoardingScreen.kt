package com.manishjajoriya.kabar.presentation.onbording

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.manishjajoriya.kabar.presentation.common.NewsButton
import com.manishjajoriya.kabar.presentation.common.NewsTextButton
import com.manishjajoriya.kabar.presentation.onbording.Dimens.MediumPadding2
import com.manishjajoriya.kabar.presentation.onbording.Dimens.PageIndicatorWidth
import com.manishjajoriya.kabar.presentation.onbording.components.OnBoardingPage
import com.manishjajoriya.kabar.presentation.onbording.components.PageIndicator
import kotlinx.coroutines.launch

@Composable
fun OnBoardingScreen(innerPaddingValues: PaddingValues, event: (OnBoardingEvent) -> Unit) {
  Column(modifier = Modifier.fillMaxSize().padding(innerPaddingValues)) {
    val pageState = rememberPagerState { pages.size }

    val buttonState = remember {
      derivedStateOf {
        when (pageState.currentPage) {
          0 -> listOf("", "Next")
          1 -> listOf("Back", "Next")
          2 -> listOf("Back", "Get Started")
          else -> listOf("", "")
        }
      }
    }

    HorizontalPager(state = pageState) { index -> OnBoardingPage(page = pages[index]) }

    Spacer(modifier = Modifier.weight(1f))

    Row(
      modifier =
        Modifier.fillMaxWidth().padding(horizontal = MediumPadding2).navigationBarsPadding(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically,
    ) {
      PageIndicator(
        pageSize = pages.size,
        selectedPage = pageState.currentPage,
        modifier = Modifier.width(PageIndicatorWidth),
      )

      Row(verticalAlignment = Alignment.CenterVertically) {
        val scope = rememberCoroutineScope()

        if (buttonState.value[0].isNotEmpty()) {
          NewsTextButton(
            text = buttonState.value[0],
            onClick = { scope.launch { pageState.animateScrollToPage(pageState.currentPage - 1) } },
          )
        }

        NewsButton(
          text = buttonState.value[1],
          onClick = {
            scope.launch {
              if (pageState.currentPage == 2) {
                event(OnBoardingEvent.SavedAppEntry)
              } else {
                pageState.animateScrollToPage(pageState.currentPage + 1)
              }
            }
          },
        )
      }
    }
  }
}
