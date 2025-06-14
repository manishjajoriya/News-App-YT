package com.manishjajoriya.kabar

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manishjajoriya.kabar.domain.usecases.app_entry.AppEntryUseCases
import com.manishjajoriya.kabar.presentation.navgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class MainViewModel @Inject constructor(private val appEntryUseCases: AppEntryUseCases) :
  ViewModel() {

  var splashCondition by mutableStateOf(true)
    private set

  var startDestination by mutableStateOf(Route.AppStartNavigation.route)
    private set

  init {
    appEntryUseCases
      .readAppEntry()
      .onEach { shouldStartFromHomeScreen ->
        startDestination =
          if (shouldStartFromHomeScreen) {
            Route.NewsNavigation.route
          } else {
            Route.AppStartNavigation.route
          }
        delay(2000)
        splashCondition = false
      }
      .launchIn(viewModelScope)
  }
}
