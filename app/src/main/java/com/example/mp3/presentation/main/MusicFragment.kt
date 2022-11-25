package com.example.mp3.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.mp3.R
import com.example.mp3.databinding.FragmentMusicBinding
import com.example.mp3.presentation.authorization.signUp.SignUpFragment.Companion.BUNDLE_USER_KEY


class MusicFragment : Fragment(R.layout.fragment_music) {
    private val binding: FragmentMusicBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivLogOut.setOnClickListener {
            findNavController().navigate(R.id.action_musicFragment_to_loginFragment)
        }
    }

}