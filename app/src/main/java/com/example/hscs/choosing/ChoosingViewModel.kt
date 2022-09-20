package com.example.hscs.choosing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.example.hscs.util.Event
import com.example.hscs.util.asEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ChoosingViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private val _uiState = MutableLiveData<ChoosingUIState>()
    val uiState: LiveData<ChoosingUIState> = _uiState

    private val _interactions = MutableLiveData<Event<ChoosingActions>>()
    val interactions: LiveData<Event<ChoosingActions>> = _interactions






    fun navigateToPatientSignIn(){
        val toPatientSignIn = ChoosingFragmentDirections.actionChoosingFragmentToPatientSignInFragment(
            // pass here args
        )
        val action = ChoosingActions.Navigate(toPatientSignIn)
        _interactions.postValue(action.asEvent())

    }

    fun navigateToSpecialist() {

        val toSpecialistSignIn = ChoosingFragmentDirections.actionChoosingFragmentToSpecialistSignInFragment(
            // pass here args
        )
        val action = ChoosingActions.Navigate(toSpecialistSignIn)
        _interactions.postValue(action.asEvent())

    }

}

sealed class ChoosingActions {
    data class Navigate(val destination: NavDirections) : ChoosingActions()
}

sealed class ChoosingUIState {

    object Loading : ChoosingUIState()

    data class Error(val title: String = "Try again", val message: Any) :
        ChoosingUIState()

    data class LimitError(val message: String) : ChoosingUIState()
}

