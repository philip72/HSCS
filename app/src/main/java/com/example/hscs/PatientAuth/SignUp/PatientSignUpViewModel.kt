package com.example.hscs.PatientAuth.SignUp

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.example.hscs.PatientAuth.SignIn.PatientSignInActions
import com.example.hscs.PatientAuth.SignIn.PatientSignInFragmentDirections
import com.example.hscs.util.Event
import com.example.hscs.util.asEvent
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import timber.log.Timber

class PatientSignUpViewModel : ViewModel() {
    private lateinit var auth: FirebaseAuth

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

/*
    fun navigateToSpecialistPage(
        firstname: String,
        lastname: String,
        email: String,
        phone: String,
        password: String
    ) {
        auth = FirebaseAuth.getInstance()


        _uiState.postValue(PatientSignUpUIState.Loading)

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Timber.tag(TAG).d("createUserWithEmail:success")
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Timber.tag(TAG).w(task.exception, "createUserWithEmail:failure")
                  */
/*  Toast.makeText(
                        this, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()*//*

                    updateUI(null)
                }
            }

        val toSpecialistPage = PatientSignUpFragmentDirections.actionPatientSignUpFragmentToSpeciliastsFragment(
            // pass here args
        )
        val action = PatientSignUpActions.Navigate(toSpecialistPage)
        _interactions.postValue(action.asEvent())



    }

    private fun updateUI(user: FirebaseUser?) {
*/
/*
        val user = Firebase.auth.currentUser
*//*

        user?.let {
            // Name, email address, and profile photo Url
            val name = user.displayName
            val email = user.email
            val photoUrl = user.photoUrl

            // Check if user's email is verified
            val emailVerified = user.isEmailVerified

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getToken() instead.
            val uid = user.uid
        }
    }

*/

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
