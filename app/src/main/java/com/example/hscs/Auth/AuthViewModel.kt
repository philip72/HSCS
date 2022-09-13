package com.example.hscs.Auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.example.hscs.util.Event

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

class AuthViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private val _uiState = MutableLiveData<AuthUIState>()
    val uiState: LiveData<AuthUIState> = _uiState

    private val _interactions = MutableLiveData<Event<AuthActions>>()
    val interactions: LiveData<Event<AuthActions>> = _interactions



    fun register() {
        _uiState.postValue(AuthUIState.Loading)

        viewModelScope.launch() {
            val userDataResponse = withContext(Dispatchers.Main) {


            }

        }
    }

}

sealed class AuthActions {
    data class Navigate(val destination: NavDirections) : AuthActions()
}

sealed class AuthUIState {

    object Loading : AuthUIState()

    data class Error(val title: String = "Try again", val message: Any) :
        AuthUIState()

    data class LimitError(val message: String) : AuthUIState()
}
