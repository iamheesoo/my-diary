package com.example.mydiary.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mydiary.R
import com.example.mydiary.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val tabList = listOf("캘린더", "감정")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            viewpager.adapter = TabAdapter(this@MainActivity.supportFragmentManager, lifecycle)
            viewpager.isUserInputEnabled = false
            TabLayoutMediator(tlTab, viewpager) { tab, position ->
                tab.text = tabList[position]
            }.attach()
        }

    }
}