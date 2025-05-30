package com.manishjajoriya.kabar.presentation.onbording

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manishjajoriya.kabar.domain.usecases.app_entry.AppEntryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class OnBoardingViewModel @Inject constructor(private val appEntryUseCases: AppEntryUseCases) :
  ViewModel() {

  fun onEvent(event: OnBoardingEvent) {
    when (event) {
      is OnBoardingEvent.SavedAppEntry -> {
        savedAppEntry()
      }
    }
  }

  private fun savedAppEntry() {
    viewModelScope.launch { appEntryUseCases.saveAppEntry.invoke() }
  }
}
