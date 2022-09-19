package com.example.hscs.PatientAuth.SignIn

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

class PatientSignInViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private val _uiState = MutableLiveData<PatientSignInUIState>()
    val uiState: LiveData<PatientSignInUIState> = _uiState

    private val _interactions = MutableLiveData<Event<PatientSignInActions>>()
    val interactions: LiveData<Event<PatientSignInActions>> = _interactions



    fun register() {
        _uiState.postValue(PatientSignInUIState.Loading)

        viewModelScope.launch() {
            val userDataResponse = withContext(Dispatchers.Main) {
            }

        }
    }
    fun navigateToSpecialistPage(){
        _uiState.postValue(PatientSignInUIState.Loading)

        val toSpecialistPage =PatientSignInFragmentDirections.actionPatientSignInFragmentToSpeciliastsFragment (
            // pass here args
        )
        val action = PatientSignInActions.Navigate(toSpecialistPage)
        _interactions.postValue(action.asEvent())
    }

    fun navigateToPatientSignUp() {
        _uiState.postValue(PatientSignInUIState.Loading)

        val toPatientSignUpPage =PatientSignInFragmentDirections.actionPatientSignInFragmentToPatientSignUpFragment (
            // pass here args
        )
        val action = PatientSignInActions.Navigate(toPatientSignUpPage)
        _interactions.postValue(action.asEvent())
    }


}


sealed class PatientSignInActions {
    data class Navigate(val destination: NavDirections) : PatientSignInActions()
}

sealed class PatientSignInUIState {

    object Loading : PatientSignInUIState()

    data class Error(val title: String = "Try again", val message: Any) :
        PatientSignInUIState()

    data class LimitError(val message: String) : PatientSignInUIState()
}
