package com.manishjajoriya.kabar.presentation.onbording.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.manishjajoriya.kabar.R
import com.manishjajoriya.kabar.presentation.onbording.Dimens.MediumPadding1
import com.manishjajoriya.kabar.presentation.onbording.Dimens.MediumPadding2
import com.manishjajoriya.kabar.presentation.onbording.Page
import com.manishjajoriya.kabar.presentation.onbording.pages
import com.manishjajoriya.kabar.ui.theme.KabarTheme

@Composable
fun OnBoardingPage(modifier: Modifier = Modifier, page: Page) {
  Column(modifier = modifier) {
    Image(
      modifier = Modifier.fillMaxWidth().fillMaxHeight(.6f),
      painter = painterResource(id = page.image),
      contentScale = ContentScale.Crop,
      contentDescription = null,
    )

    Spacer(modifier = Modifier.height(MediumPadding1))

    Text(
      text = page.title,
      modifier = Modifier.padding(horizontal = MediumPadding2),
      style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
      color = colorResource(R.color.display_small),
    )

    Text(
      text = page.description,
      modifier = Modifier.padding(horizontal = MediumPadding2),
      style = MaterialTheme.typography.bodyMedium,
      color = colorResource(R.color.text_medium),
    )
  }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun OnBoardingPagePreview() {
  KabarTheme { OnBoardingPage(page = pages[0]) }
}
