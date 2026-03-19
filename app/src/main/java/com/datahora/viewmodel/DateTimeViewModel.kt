package com.datahora.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.text.SimpleDateFormat
import java.util.*

import com.datahora.model.DateTimeState

class DateTimeViewModel : ViewModel() {

    private val _state = MutableStateFlow(DateTimeState())
    val state: StateFlow<DateTimeState> = _state

    fun updateDate(newDate: Long) {
        _state.value = _state.value.copy(date = newDate)
    }

    fun updateTime(hour: Int, minute: Int) {
        _state.value = _state.value.copy(hour = hour, minute = minute)
    }

    fun getFormattedDate(): String {
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return sdf.format(Date(_state.value.date))
    }

    fun getFormattedTime(): String {
        return String.format(
            "%02d:%02d",
            _state.value.hour,
            _state.value.minute
        )
    }
}