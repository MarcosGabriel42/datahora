package com.datahora.model

import java.util.Calendar

data class DateTimeState(
    val date: Long = System.currentTimeMillis(),
    val hour: Int = Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
    val minute: Int = Calendar.getInstance().get(Calendar.MINUTE)
)