package com.manishjajoriya.kabar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.manishjajoriya.kabar.presentation.navgraph.NavGraph
import com.manishjajoriya.kabar.ui.theme.KabarTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  val viewModel: MainViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    installSplashScreen().apply { setKeepOnScreenCondition { viewModel.splashCondition } }
    super.onCreate(savedInstanceState)

    enableEdgeToEdge()
    setContent {
      val isSystemInDarkMode = isSystemInDarkTheme()
      KabarTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          val startDestination = viewModel.startDestination
          NavGraph(startDestination = startDestination, innerPadding = innerPadding)
        }
      }
    }
  }
}
