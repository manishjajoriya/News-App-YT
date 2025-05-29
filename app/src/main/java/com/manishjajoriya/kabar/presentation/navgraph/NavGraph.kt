package com.manishjajoriya.kabar.presentation.navgraph

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.manishjajoriya.kabar.presentation.onbording.OnBoardingScreen
import com.manishjajoriya.kabar.presentation.onbording.OnBoardingViewModel

@Composable
fun NavGraph(innerPadding: PaddingValues, startDestination: String) {
  val navController = rememberNavController()

  NavHost(navController = navController, startDestination = startDestination) {
    navigation(
      route = Route.AppStartNavigation.route,
      startDestination = Route.OnBoardingScreen.route,
    ) {
      composable(route = Route.OnBoardingScreen.route) {
        val viewModel: OnBoardingViewModel = hiltViewModel()
        OnBoardingScreen(innerPadding, viewModel::onEvent)
      }
    }

    navigation(
      route = Route.NewsNavigation.route,
      startDestination = Route.NewsNavigationScreen.route,
    ) {
      composable(route = Route.NewsNavigationScreen.route) {
        Text(text = "News Navigation Screen", modifier = Modifier.padding(innerPadding))
      }
    }
  }
}
