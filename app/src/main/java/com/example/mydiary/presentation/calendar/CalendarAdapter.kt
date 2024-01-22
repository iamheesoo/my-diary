package com.example.mydiary.presentation.calendar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mydiary.databinding.ItemCalendarBinding
import com.example.mydiary.presentation.calendar.CalendarConstant.ROW_SIZE
import com.example.mydiary.presentation.utils.convertDateFormat
import java.util.Calendar
import java.util.Date

class CalendarAdapter(
) : RecyclerView.Adapter<CalendarViewHolder>() {
    private var center = Int.MAX_VALUE / 2
    private var calendar = Calendar.getInstance()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        val binding =
            ItemCalendarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CalendarViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        with(calendar) {
            time = Date()
            set(Calendar.DAY_OF_MONTH, 1)
            add(Calendar.MONTH, position - center)

            val dayList = setCalendarDay()
            holder.bind(
                date = convertDateFormat(
                    year = calendar.get(Calendar.YEAR),
                    month = calendar.get(Calendar.MONTH)
                ),
                dayList = dayList,
                tempMonth = calendar.get(Calendar.MONTH)
            )
        }
    }

    private fun setCalendarDay(): List<Date> {
        var dayList = mutableListOf<Date>()
        repeat(ROW_SIZE) { week_index ->
            repeat(Week.values().size) { week_day_index ->
                calendar.add(
                    Calendar.DAY_OF_MONTH,
                    (1 - calendar.get(Calendar.DAY_OF_WEEK)) + week_day_index
                )
                dayList.add(calendar.time)
            }
            calendar.add(Calendar.WEEK_OF_MONTH, 1)
        }
        return dayList
    }

}

class CalendarViewHolder(private val binding: ItemCalendarBinding) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        with(binding) {
            rvWeek.layoutManager = GridLayoutManager(root.context, Week.values().size)
            rvWeek.adapter = WeekAdapter(weekList = Week.values().toList())
            rvDay.layoutManager = GridLayoutManager(root.context, Week.values().size)
        }
    }

    fun bind(date: String, dayList: List<Date>, tempMonth: Int) {
        with(binding) {
            tvMonth.text = date
            rvDay.adapter = DayAdapter(tempMonth = tempMonth,dayList = dayList)
        }
    }
}