package com.example.mp3.presentation.authorization.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.data.module.InfoUserModule
import com.example.mp3.R
import com.example.mp3.databinding.FragmentLoginBinding
import com.example.mp3.presentation.authorization.signUp.SignUpFragment.Companion.BUNDLE_USER_KEY
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginFragment : Fragment(R.layout.fragment_login) {

    private val binding: FragmentLoginBinding by viewBinding()
    private val viewModel by viewModel<LoginViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnLogInClickListener()
        observeViewModelFields()

        binding.tvSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }
    }

    private fun setOnLogInClickListener() = with(binding) {
        binding.btnLogin.setOnClickListener {
            viewModel.checkUser(etLogin.text.toString(), etPassword.text.toString())
        }
    }

    private fun observeViewModelFields() = with(viewModel) {
        logInError.observe(viewLifecycleOwner) {
            Toast.makeText(
                requireContext(),
                R.string.fragment_login_error_login_user,
                Toast.LENGTH_SHORT
            ).show()
        }

        successLoginEvent.observe(viewLifecycleOwner) {
            val bundle = Bundle()
            bundle.putSerializable(BUNDLE_USER_KEY, InfoUserModule(it.userName, it.email))
            findNavController().navigate(R.id.action_loginFragment_to_musicFragment, bundle)
        }
    }
}