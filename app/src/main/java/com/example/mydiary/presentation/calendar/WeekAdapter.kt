package com.example.mydiary.presentation.calendar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mydiary.databinding.ItemWeekDayBinding

class WeekAdapter(
    val weekList: List<Week>
) : RecyclerView.Adapter<WeekDayViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeekDayViewHolder {
        val binding = ItemWeekDayBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return WeekDayViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return weekList.size
    }

    override fun onBindViewHolder(holder: WeekDayViewHolder, position: Int) {
        holder.bind(weekList[position].name)
    }
}


class WeekDayViewHolder(
    private val binding: ItemWeekDayBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(text: String) {
        with(binding) {
            tvWeekDay.text = text
        }
    }
}