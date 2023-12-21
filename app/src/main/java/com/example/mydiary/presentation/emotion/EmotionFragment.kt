package com.example.mydiary.presentation.emotion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mydiary.databinding.FragmentEmotionBinding

class EmotionFragment : Fragment() {
    private val binding: FragmentEmotionBinding by lazy {
        FragmentEmotionBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }
}