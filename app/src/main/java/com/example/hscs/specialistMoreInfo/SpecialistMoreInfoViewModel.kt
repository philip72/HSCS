package com.example.hscs.specialistMoreInfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.example.hscs.SpecialistAuth.SignUp.SpecialistSignUpActions
import com.example.hscs.SpecialistAuth.SignUp.SpecialistSignUpFragmentDirections
import com.example.hscs.SpecialistAuth.SignUp.SpecialistSignUpUIState
import com.example.hscs.util.Event
import com.example.hscs.util.asEvent

class SpecialistMoreInfoViewModel : ViewModel() {
    private val _uiState = MutableLiveData<SpecialistMoreDetailsUIState>()
    val uiState: LiveData<SpecialistMoreDetailsUIState> = _uiState

    private val _interactions = MutableLiveData<Event<SpecialistMoreDetailsActions>>()
    val interactions: LiveData<Event<SpecialistMoreDetailsActions>> = _interactions
//    fun navigateToSpecialistTextPage() {
//        _uiState.postValue(SpecialistMoreDetailsUIState .Loading)
//
//        val toSpecialistTextPage = SpecialistMoreInfoFragmentDirections.actionSpecialistMoreInfoFragmentToSpecialistTextPageFragment(
//            // pass here args
//        )
//        val action = SpecialistMoreDetailsActions.Navigate(toSpecialistTextPage)
//        _interactions.postValue(action.asEvent())
//    }
    // TODO: Implement the ViewModel
}
sealed class SpecialistMoreDetailsActions {
    data class Navigate(val destination: NavDirections) : SpecialistMoreDetailsActions()

}

sealed class SpecialistMoreDetailsUIState{
    object Loading : SpecialistMoreDetailsUIState()

    data class Error(val title: String = "Try again", val message: Any) :
        SpecialistMoreDetailsUIState()

    data class LimitError(val message: String) : SpecialistMoreDetailsUIState()

}