package com.manishjajoriya.kabar.presentation.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import com.manishjajoriya.kabar.R
import com.manishjajoriya.kabar.domain.model.Article
import com.manishjajoriya.kabar.domain.model.Source
import com.manishjajoriya.kabar.presentation.onbording.Dimens.ArticleCardSize
import com.manishjajoriya.kabar.presentation.onbording.Dimens.ExtraSmallPadding
import com.manishjajoriya.kabar.presentation.onbording.Dimens.ExtraSmallPadding2
import com.manishjajoriya.kabar.presentation.onbording.Dimens.SmallIconSize
import com.manishjajoriya.kabar.ui.theme.KabarTheme

@Composable
fun ArticleCard(modifier: Modifier = Modifier, article: Article, onClick: () -> Unit) {

  val context = LocalContext.current

  Row(modifier = modifier.clickable { onClick() }) {
    AsyncImage(
      modifier = Modifier.size(ArticleCardSize).clip(MaterialTheme.shapes.medium),
      contentScale = ContentScale.Crop,
      model = ImageRequest.Builder(context).data(article.urlToImage).build(),
      contentDescription = null,
    )

    Column(
      verticalArrangement = Arrangement.SpaceAround,
      modifier = Modifier.padding(horizontal = ExtraSmallPadding).height(ArticleCardSize),
    ) {
      Text(
        text = article.title,
        style = MaterialTheme.typography.bodyMedium,
        color = colorResource(R.color.text_title),
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
      )

      Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
          text = article.source.name,
          style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
          color = colorResource(R.color.body),
          maxLines = 2,
          overflow = TextOverflow.Ellipsis,
        )

        Spacer(modifier = Modifier.width(ExtraSmallPadding2))

        Icon(
          painter = painterResource(R.drawable.ic_time),
          contentDescription = null,
          modifier = Modifier.size(SmallIconSize),
          tint = colorResource(R.color.body),
        )

        Spacer(modifier = Modifier.width(ExtraSmallPadding2))

        Text(
          text = article.publishedAt,
          style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
          color = colorResource(R.color.body),
          maxLines = 2,
          overflow = TextOverflow.Ellipsis,
        )
      }
    }
  }
}

@Preview(showBackground = false)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewArticleCard() {
  KabarTheme {
    ArticleCard(
      article =
        Article(
          author = "Manish",
          content = "Fight",
          description = "Temporary description",
          publishedAt = "Today",
          source = Source("1", "BBC"),
          title =
            "Tggggggggggggggggggggggggggggggghhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhgggggggggggggggggggggggggggggggg",
          url = "https://example.com/temp-url",
          urlToImage = "https://example.com/temp-image.jpg",
        ),
      onClick = {},
    )
  }
}
