package com.example.mp3.presentation.authorization.signUp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.mp3.R
import com.example.mp3.databinding.FragmentSignUpBinding


class SignUpFragment : Fragment(R.layout.fragment_sign_up) {
    private val binding: FragmentSignUpBinding by viewBinding()
    private val vm: SignUpViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnSignUpClickListener()

        vm.errorToastUserName.observe(viewLifecycleOwner) {
            resetErrors()
            binding.etUserName.error = getString(R.string.fragment_login_error_empty_user_name)
        }
        vm.errorToastEmail.observe(viewLifecycleOwner) {
            resetErrors()
            binding.etEmail.error = getString(R.string.fragment_login_error_email)
        }
        vm.errorToastPassword.observe(viewLifecycleOwner) {
            resetErrors()
            binding.etConfirmPassword.error =
                getString(R.string.fragment_login_error_confirm_password)
        }
        vm.errorToastPasswordConfirm.observe(viewLifecycleOwner) {
            resetErrors()
            binding.etConfirmPassword.error =
                getString(R.string.fragment_login_error_confirm_password)
        }
    }

    private fun setOnSignUpClickListener() = with(binding) {
        btnSignUp.setOnClickListener {
            vm.validateInputs(
                etUserName.text.toString(),
                etEmail.text.toString(),
                etPassword.text.toString(),
                etConfirmPassword.text.toString()
            )
        }
    }

    private fun successObserver() {

    }


    private fun resetErrors() = with(binding) {
        etUserName.error = null
        etEmail.error = null
        etPassword.error = null
        etConfirmPassword.error = null
    }


}