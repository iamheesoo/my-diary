package com.example.mydiary.presentation.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.mydiary.databinding.FragmentCalendarBinding

class CalendarFragment : Fragment() {
    private val binding: FragmentCalendarBinding by lazy {
        FragmentCalendarBinding.inflate(layoutInflater)
    }

    private val calendarAdapter = CalendarAdapter()
    private val snapHelper = PagerSnapHelper()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            rvCalendar.layoutManager =
                LinearLayoutManager(root.context, LinearLayoutManager.HORIZONTAL, false)
            rvCalendar.adapter = calendarAdapter
            rvCalendar.scrollToPosition(Int.MAX_VALUE / 2)
            snapHelper.attachToRecyclerView(rvCalendar)
        }
    }
}