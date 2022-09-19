package com.example.hscs.PatientAuth.SignUp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.example.hscs.PatientAuth.SignIn.PatientSignInActions
import com.example.hscs.PatientAuth.SignIn.PatientSignInFragmentDirections
import com.example.hscs.util.Event
import com.example.hscs.util.asEvent

class PatientSignUpViewModel : ViewModel() {
    private val _uiState = MutableLiveData<PatientSignUpUIState>()
    val uiState: LiveData<PatientSignUpUIState> = _uiState

    private val _interactions = MutableLiveData<Event<PatientSignUpActions>>()
    val interactions: LiveData<Event<PatientSignUpActions>> = _interactions
    fun navigateToSpecialistPage() {
        _uiState.postValue(PatientSignUpUIState.Loading)

        val toSpecialistPage = PatientSignUpFragmentDirections.actionPatientSignUpFragmentToSpeciliastsFragment(
            // pass here args
        )
        val action = PatientSignUpActions.Navigate(toSpecialistPage)
        _interactions.postValue(action.asEvent())
    }

    fun navigateToPatientSignIn() {
        _uiState.postValue(PatientSignUpUIState.Loading)

        val toPatientSignInPage =PatientSignUpFragmentDirections.actionPatientSignUpFragmentToPatientSignInFragment (
            // pass here args
        )
        val action = PatientSignUpActions.Navigate(toPatientSignInPage)
        _interactions.postValue(action.asEvent())
    }
    // TODO: Implement the ViewModel
}

sealed class PatientSignUpActions {
    data class Navigate(val destination: NavDirections) : PatientSignUpActions()

}

sealed class PatientSignUpUIState {
    object Loading : PatientSignUpUIState()

    data class Error(val title: String = "Try again", val message: Any) :
        PatientSignUpUIState()

    data class LimitError(val message: String) : PatientSignUpUIState()

}
