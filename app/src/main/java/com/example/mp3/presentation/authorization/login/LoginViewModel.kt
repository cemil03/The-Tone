package com.example.mp3.presentation.authorization.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.module.InfoUserModule
import com.example.domain.usecase.LoginUserUseCase
import kotlinx.coroutines.launch

class LoginViewModel(private val loginUserUseCase: LoginUserUseCase) : ViewModel() {

    private val _errorLogInEvent: MutableLiveData<Boolean> = MutableLiveData()
    val errorLogInEvent: LiveData<Boolean> get() = _errorLogInEvent

    private val _successLoginEvent: MutableLiveData<InfoUserModule> = MutableLiveData()
    val successLoginEvent: LiveData<InfoUserModule> get() = _successLoginEvent

    fun checkUser(userName: String, password: String) {
        viewModelScope.launch {
            val user = loginUserUseCase.execute(userName, password)
            if (user != null) {
                _successLoginEvent.value = InfoUserModule(user.userName, user.email)
            }else {
                _errorLogInEvent.value = true
            }
        }
    }


}