package pl.edu.pb.androidnativeapp.ui.hardware.sensor.light

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import com.mutualmobile.composesensors.rememberLightSensorState

@Composable
fun AndroidLightScreen() {
    val state = rememberLightSensorState()
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
        ) {
            Text(text = "Illuminance: ${state.illuminance}", fontSize = 20.sp)
        }
    }
}
