package com.example.hscs.SpecialistAuth.SignIn

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.example.hscs.PatientAuth.SignIn.PatientSignInActions
import com.example.hscs.PatientAuth.SignIn.PatientSignInFragmentDirections
import com.example.hscs.PatientAuth.SignIn.PatientSignInUIState
import com.example.hscs.util.Event
import com.example.hscs.util.asEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SpecialistSignInViewModel : ViewModel() {
    private val _uiState = MutableLiveData<SpecialistSigninUIState>()
    val uiState: LiveData<SpecialistSigninUIState> = _uiState

    private val _interactions = MutableLiveData<Event<SpecialistSignInActions>>()
    val interactions: LiveData<Event<SpecialistSignInActions>> = _interactions



    fun register() {
        _uiState.postValue(SpecialistSigninUIState.Loading)

        viewModelScope.launch() {
            val userDataResponse = withContext(Dispatchers.Main) {
            }

        }
    }
    fun navigateToSpecialistTextPage() {
        _uiState.postValue(SpecialistSigninUIState.Loading)

        val toSpecialistTextPage = SpecialistSignInFragmentDirections.actionSpecialistSignInFragmentToSpecialistTextPageFragment (
            // pass here args
        )
        val action = SpecialistSignInActions.Navigate(toSpecialistTextPage)
        _interactions.postValue(action.asEvent())
    }

    fun navigateToSpecialistSignUp() {
        _uiState.postValue(SpecialistSigninUIState.Loading)

        val toSpecialistSignUp = SpecialistSignInFragmentDirections.actionSpecialistSignInFragmentToSpecialistSignUpFragment (
            // pass here args
        )
        val action = SpecialistSignInActions.Navigate(toSpecialistSignUp)
        _interactions.postValue(action.asEvent())
    }
    // TODO: Implement the ViewModel
}
sealed class SpecialistSignInActions {
    data class Navigate(val destination: NavDirections) : SpecialistSignInActions()
}

sealed class SpecialistSigninUIState {

    object Loading : SpecialistSigninUIState()

    data class Error(val title: String = "Try again", val message: Any) :
        SpecialistSigninUIState()

    data class LimitError(val message: String) : SpecialistSigninUIState()
}