package com.example.hscs.SpecialistAuth.SignUp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.example.hscs.PatientAuth.SignUp.PatientSignUpFragmentDirections
import com.example.hscs.PatientAuth.SignUp.PatientSignUpUIState
import com.example.hscs.util.Event
import com.example.hscs.util.asEvent

class SpecialistSignUpViewModel : ViewModel() {
    private val _uiState = MutableLiveData<SpecialistSignUpUIState>()
    val uiState: LiveData<SpecialistSignUpUIState> = _uiState

    private val _interactions = MutableLiveData<Event<SpecialistSignUpActions>>()
    val interactions: LiveData<Event<SpecialistSignUpActions>> = _interactions
    fun navigateToSpecialistMoreDetails() {
        _uiState.postValue(SpecialistSignUpUIState .Loading)

        val toSpecialistMoreDetails = SpecialistSignUpFragmentDirections.actionSpecialistSignUpFragmentToSpecialistMoreInfoFragment(
            // pass here args
        )
        val action = SpecialistSignUpActions.Navigate(toSpecialistMoreDetails)
        _interactions.postValue(action.asEvent())
    }

    fun navigateToSpecialistSignIn() {
        _uiState.postValue(SpecialistSignUpUIState.Loading)

        val toSpecialistSignInPage =SpecialistSignUpFragmentDirections.actionSpecialistSignUpFragmentToSpecialistSignInFragment (
            // pass here args
        )
        val action = SpecialistSignUpActions.Navigate(toSpecialistSignInPage)
        _interactions.postValue(action.asEvent())
    }
    // TODO: Implement the ViewModel
}
sealed class SpecialistSignUpActions {
    data class Navigate(val destination: NavDirections) : SpecialistSignUpActions()

}

sealed class SpecialistSignUpUIState {
    object Loading : SpecialistSignUpUIState()

    data class Error(val title: String = "Try again", val message: Any) :
        SpecialistSignUpUIState()

    data class LimitError(val message: String) : SpecialistSignUpUIState()

}