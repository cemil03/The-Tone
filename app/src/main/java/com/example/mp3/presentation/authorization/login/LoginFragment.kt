package com.example.mp3.presentation.authorization.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.data.module.InfoUserModule
import com.example.mp3.R
import com.example.mp3.databinding.FragmentLoginBinding
import com.example.mp3.presentation.authorization.signUp.SignUpFragment.Companion.BUNDLE_USER_KEY


class LoginFragment : Fragment(R.layout.fragment_login) {

    private val binding: FragmentLoginBinding by viewBinding()
    private val vm by viewModels<LoginViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnLogInClickListener()
        successLogInObserver()

        vm.errorLogInEvent.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), R.string.fragment_login_error_login_user, Toast.LENGTH_SHORT).show()
        }

        binding.tvSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }
    }

    private fun successLogInObserver() {
        val bundle = Bundle()
        vm.successLoginEvent.observe(viewLifecycleOwner) {
            bundle.putSerializable(BUNDLE_USER_KEY,InfoUserModule(it.userName,it.email))
        }
    }

    private fun setOnLogInClickListener() = with(binding) {
        binding.btnLogin.setOnClickListener {
            vm.checkUser(etLogin.text.toString(), etPassword.text.toString())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }


}