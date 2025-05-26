package com.manishjajoriya.kabar

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.manishjajoriya.kabar.domain.usecases.AppEntryUseCases
import com.manishjajoriya.kabar.presentation.onbording.OnBoardingScreen
import com.manishjajoriya.kabar.presentation.onbording.OnBoardingViewModel
import com.manishjajoriya.kabar.ui.theme.KabarTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

  @Inject lateinit var useCase: AppEntryUseCases

  override fun onCreate(savedInstanceState: Bundle?) {
    installSplashScreen()
    super.onCreate(savedInstanceState)

    lifecycleScope.launch { useCase.readAppEntry().collect { Log.d("Test", it.toString()) } }
    enableEdgeToEdge()
    setContent {
      KabarTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          val viewModel: OnBoardingViewModel by viewModels()
          OnBoardingScreen(innerPadding, viewModel::onEvent)
        }
      }
    }
  }
}
