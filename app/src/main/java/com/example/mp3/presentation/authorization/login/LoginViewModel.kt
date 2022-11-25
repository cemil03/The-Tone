package com.example.mp3.presentation.authorization.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.module.InfoUserModule
import com.example.domain.usecase.GetUserUseCase
import kotlinx.coroutines.launch

class LoginViewModel(private val getUserUseCase: GetUserUseCase) : ViewModel() {

    private val _logInError: MutableLiveData<Boolean> = MutableLiveData()
    val logInError: LiveData<Boolean> get() = _logInError

    private val _successLoginEvent: MutableLiveData<InfoUserModule> = MutableLiveData()
    val successLoginEvent: LiveData<InfoUserModule> get() = _successLoginEvent

    fun checkUser(userName: String, password: String) {
        viewModelScope.launch {
            val user = getUserUseCase(userName, password)
            if (user != null) {
                _successLoginEvent.value = InfoUserModule(user.userName, user.email)
            } else {
                _logInError.value = true
            }
        }
    }

}