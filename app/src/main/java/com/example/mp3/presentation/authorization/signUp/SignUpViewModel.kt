package com.example.mp3.presentation.authorization.signUp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.usecase.RegisterUserUseCase
import android.util.Patterns
import androidx.lifecycle.viewModelScope
import com.example.data.module.InfoUserModule
import com.example.domain.entity.User
import kotlinx.coroutines.launch
import java.util.regex.Pattern


class SignUpViewModel(private val registerUserUseCase: RegisterUserUseCase) : ViewModel() {

    private val _errorToastUserName: MutableLiveData<Boolean> = MutableLiveData()
    val errorToastUserName: LiveData<Boolean> get() = _errorToastUserName

    private val _errorToastEmail: MutableLiveData<Boolean> = MutableLiveData()
    val errorToastEmail: LiveData<Boolean> get() = _errorToastEmail

    private val _errorToastPassword: MutableLiveData<Boolean> = MutableLiveData()
    val errorToastPassword: LiveData<Boolean> get() = _errorToastPassword

    private val _errorToastPasswordConfirm: MutableLiveData<Boolean> = MutableLiveData()
    val errorToastPasswordConfirm: LiveData<Boolean> get() = _errorToastPasswordConfirm

    private val _successSignUpEvent: MutableLiveData<InfoUserModule> = MutableLiveData()
    val successSignUpEvent: LiveData<InfoUserModule> get() = _successSignUpEvent



    fun validateInputs(
        userName: String,
        email: String,
        password: String,
        confirmPassword: String
    ) {
        when {
            userName.isEmpty() -> _errorToastUserName.value = true
            !isValidateEmail(email) -> _errorToastEmail.value = true
            !isValidatePassword(password) -> _errorToastPassword.value = true
            !isValidateConfirmPassword(
                password,
                confirmPassword
            ) -> _errorToastPasswordConfirm.value = true
            else -> {
                _successSignUpEvent.value = InfoUserModule(userName, email)
            }
        }
    }


    private fun isValidateEmail(email: String) = Patterns.EMAIL_ADDRESS.matcher(email).matches()

    private fun isValidatePassword(password: String) =
        Pattern.compile(PASSWORD_PATTERN).matcher(password).matches()

    private fun isValidateConfirmPassword(password: String, confirmPassword: String) =
        password == confirmPassword

    fun registerUser(user: User) {
        viewModelScope.launch {
            registerUserUseCase(user)
        }
    }

    companion object {
        const val PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*.!@\$%^&()\\[\\]{:;<>,?/~_+\\-=|]).{8,64}$"
    }


}