package com.alkemy.ongsomosmas.ui.signup

import android.util.Patterns
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alkemy.ongsomosmas.R
import com.alkemy.ongsomosmas.data.Resource
import com.alkemy.ongsomosmas.data.model.signup.SignUpResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.regex.Pattern

class SignUpViewModel @ViewModelInject constructor(
    private val registerUser: RegisterUserUseCase
) :
    ViewModel() {

    private val _signUpFormState = MutableLiveData<SignUpFormState>()
    val signUpFormState: LiveData<SignUpFormState> = _signUpFormState

    private val _signUpState = MutableLiveData<SignUpState>()
    val signUpState: LiveData<SignUpState> = _signUpState

    sealed class SignUpState {
        data class Success(val message: String) : SignUpState()
        data class PasswordError(val resourceId: Int) : SignUpState()
        data class Loading(val isLoading: Boolean) : SignUpState()
        object Error : SignUpState()
    }

    private val _signUpResponse: MutableLiveData<Resource<SignUpResponse>> = MutableLiveData()
    val signUpResponse: LiveData<Resource<SignUpResponse>> = _signUpResponse

    // Validate Data
    fun onDataChanged(
        name: String,
        email: String,
        password: String,
        confirmPassword: String
    ) {
        if (!isNameValid(name)) {
            _signUpFormState.value = SignUpFormState(nameError = R.string.name_text)
        } else if (!isEmailValid(email)) {
            _signUpFormState.value = SignUpFormState(emailError = R.string.email_text)
        } else if (!isPasswordValid(password)) {
            _signUpFormState.value =
                SignUpFormState(passwordError = R.string.password_text)
            // SignUpState.PasswordError(R.string.password_text)
        } else if (!isPasswordSame(password, confirmPassword)) {
            _signUpFormState.value =
                SignUpFormState(samePasswordError = R.string.same_password_text)
        } else {
            _signUpFormState.value = SignUpFormState(isDataValid = true)
        }

    }

    fun signUp(name: String, email: String, password: String) =
        viewModelScope.launch(Dispatchers.Main) {
            val result = withContext(Dispatchers.IO) {
                registerUser(name, email, password)
            }

            _signUpResponse.value = result
        }

    // Check name
    private fun isNameValid(name: String) =
        Pattern.compile("^(?=\\S+\$).{3,}").matcher(name).matches()

    // Check email
    private fun isEmailValid(email: String) =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()

    // Check password
    private fun isPasswordValid(password: String): Boolean {
        val passwordPattern = "^(?=.*[0-9])(?=.*[A-Z])(?=\\S+\$).{8,}"
        val pattern = Pattern.compile(passwordPattern)
        return pattern.matcher(password).matches()
    }

    private fun isPasswordSame(firstPass: String, secondPass: String) =
        firstPass == secondPass
}