package com.example.mydiary.presentation.calendar

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mydiary.databinding.ItemDayBinding
import com.example.mydiary.presentation.calendar.CalendarConstant.ROW_SIZE
import java.util.Date

class DayAdapter(
    private val tempMonth: Int,
    private val dayList: List<Date>
) : RecyclerView.Adapter<DayViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder {
        val binding = ItemDayBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DayViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return ROW_SIZE * 7
    }

    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
        holder.bind(date = dayList[position], tempMonth = tempMonth, position = position)
    }
}

class DayViewHolder(private val binding: ItemDayBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(date: Date, tempMonth: Int, position: Int) {
        with(binding) {
            tvDay.text = date.date.toString()
            tvDay.setTextColor(
                when (position % Week.values().size) {
                    0 -> Color.RED
                    6 -> Color.BLUE
                    else -> Color.BLACK
                }
            )
            if (tempMonth != date.month + 1) {
                tvDay.alpha = 0.4f
            }
        }
    }
}