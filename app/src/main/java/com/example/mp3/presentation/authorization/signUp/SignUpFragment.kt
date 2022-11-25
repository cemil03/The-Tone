package com.example.mp3.presentation.authorization.signUp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.data.module.InfoUserModule
import com.example.domain.entity.User
import com.example.mp3.R
import com.example.mp3.databinding.FragmentSignUpBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class SignUpFragment : Fragment(R.layout.fragment_sign_up) {
    private val binding: FragmentSignUpBinding by viewBinding()
    private val viewModel: SignUpViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setOnSignUpClickListener()
        observeViewModelFields()
    }

    private fun setOnSignUpClickListener() = with(binding) {
        btnSignUp.setOnClickListener {
            viewModel.validateInputs(
                etUserName.text.toString(),
                etEmail.text.toString(),
                etPassword.text.toString(),
                etConfirmPassword.text.toString()
            )
        }
    }

    private fun observeViewModelFields() = with(viewModel) {
        viewModel.errorToastUserName.observe(viewLifecycleOwner) {
            resetErrors()
            binding.tilUserName.error = getString(R.string.fragment_sign_up_error_empty_user_name)
        }
        viewModel.errorToastEmail.observe(viewLifecycleOwner) {
            resetErrors()
            binding.tilEmail.error = getString(R.string.fragment_sign_up_error_email)
        }
        viewModel.errorToastPassword.observe(viewLifecycleOwner) {
            resetErrors()
            binding.tilPassword.error =
                getString(R.string.fragment_sign_up_error_password)
        }
        viewModel.errorToastPasswordConfirm.observe(viewLifecycleOwner) {
            resetErrors()
            binding.tilConfirmPassword.error =
                getString(R.string.fragment_sign_up_error_confirm_password)
        }

        viewModel.successSignUpEvent.observe(viewLifecycleOwner) {
            with(binding) {
                val user = User(
                    0,
                    etUserName.text.toString(),
                    etEmail.text.toString(),
                    etPassword.text.toString()
                )
                val bundle = Bundle()
                viewModel.registerUser(user)
                bundle.putSerializable(BUNDLE_USER_KEY, it)
                findNavController().navigate(R.id.action_signUpFragment_to_musicFragment, bundle)
            }
        }
    }

    private fun resetErrors() = with(binding) {
        tilUserName.error = null
        tilEmail.error = null
        tilPassword.error = null
        tilConfirmPassword.error = null
    }

    companion object {
        const val BUNDLE_USER_KEY = "user"
    }

}