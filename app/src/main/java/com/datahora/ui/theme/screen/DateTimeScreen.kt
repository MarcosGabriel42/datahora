package com.datahora.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

import com.datahora.viewmodel.DateTimeViewModel
import com.datahora.ui.theme.components.DatePickerComponent
import com.datahora.ui.theme.components.TimePickerComponent

@Composable
fun DateTimeScreen(
    viewModel: DateTimeViewModel = viewModel()
) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {

        // 📅 DATA FORMATADA
        Text(text = "Data: ${viewModel.getFormattedDate()}")

        Spacer(modifier = Modifier.height(8.dp))

        // ⏰ HORA FORMATADA
        Text(text = "Hora: ${viewModel.getFormattedTime()}")

        Spacer(modifier = Modifier.height(24.dp))

        // 📅 COMPONENTE DE DATA
        DatePickerComponent { selectedDate ->
            viewModel.updateDate(selectedDate)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // ⏰ COMPONENTE DE HORA
        TimePickerComponent { hour, minute ->
            viewModel.updateTime(hour, minute)
        }
    }
}