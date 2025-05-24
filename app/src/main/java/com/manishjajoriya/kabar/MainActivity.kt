package com.manishjajoriya.kabar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.manishjajoriya.kabar.presentation.onbording.OnBoardingScreen
import com.manishjajoriya.kabar.ui.theme.KabarTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    installSplashScreen()
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      KabarTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          OnBoardingScreen(innerPadding)
        }
      }
    }
  }
}
