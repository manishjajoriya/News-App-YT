package com.manishjajoriya.kabar.presentation.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.manishjajoriya.kabar.R
import com.manishjajoriya.kabar.presentation.onbording.Dimens.ArticleCardSize
import com.manishjajoriya.kabar.presentation.onbording.Dimens.ExtraSmallPadding
import com.manishjajoriya.kabar.presentation.onbording.Dimens.MediumPadding1
import com.manishjajoriya.kabar.ui.theme.KabarTheme

fun Modifier.shimmerEffect() = composed {
  val transition = rememberInfiniteTransition()
  val alpha =
    transition
      .animateFloat(
        initialValue = 0.2f,
        targetValue = 0.9f,
        animationSpec =
          infiniteRepeatable(
            animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Reverse,
          ),
      )
      .value
  background(color = colorResource(R.color.shimmer).copy(alpha = alpha))
}

@Composable
fun ArticleCardShimmerEffect(modifier: Modifier = Modifier) {
  Row(modifier = modifier) {
    Box(modifier = Modifier.size(ArticleCardSize).clip(MaterialTheme.shapes.medium).shimmerEffect())

    Column(
      verticalArrangement = Arrangement.SpaceAround,
      modifier = Modifier.padding(horizontal = ExtraSmallPadding).height(ArticleCardSize),
    ) {
      Box(
        modifier =
          Modifier.fillMaxWidth().height(30.dp).padding(horizontal = MediumPadding1).shimmerEffect()
      )

      Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
          modifier =
            Modifier.fillMaxWidth(.5f)
              .height(15.dp)
              .padding(horizontal = MediumPadding1)
              .shimmerEffect()
        )
      }
    }
  }
}

@Preview(showBackground = false)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun ArticleCardShimmerEffectPreview() {
  KabarTheme { ArticleCardShimmerEffect() }
}
