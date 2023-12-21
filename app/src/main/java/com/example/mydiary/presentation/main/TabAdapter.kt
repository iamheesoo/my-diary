package com.example.mydiary.presentation.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mydiary.presentation.calendar.CalendarFragment
import com.example.mydiary.presentation.emotion.EmotionFragment
import java.lang.IllegalArgumentException

class TabAdapter(
    private val fragmentManager: FragmentManager,
    private val lifecycle: Lifecycle,
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CalendarFragment()
            1 -> EmotionFragment()
            else -> throw IllegalArgumentException("Invalid tab position")
        }
    }
}