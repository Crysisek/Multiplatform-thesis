package pl.edu.pb.kotlinmultiplatformapp.ui

import androidx.compose.runtime.Composable

interface HardwareUIFactory {

    @Composable
    fun CameraScreen()

    @Composable
    fun GpsScreen()

    @Composable
    fun AccelerometerScreen()

    @Composable
    fun LightScreen()
}
