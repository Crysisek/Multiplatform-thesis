package pl.edu.pb.androidnativeapp.ui.hardware.sensor.accelerometer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import com.mutualmobile.composesensors.rememberAccelerometerSensorState

@Composable
fun AndroidAccelerometerScreen() {
    val state = rememberAccelerometerSensorState()
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
        ) {
            Text(text = "Force X: ${state.xForce}", fontSize = 20.sp)
            Text(text = "Force Y: ${state.yForce}", fontSize = 20.sp)
            Text(text = "Force Z: ${state.zForce}", fontSize = 20.sp)
        }
    }
}
