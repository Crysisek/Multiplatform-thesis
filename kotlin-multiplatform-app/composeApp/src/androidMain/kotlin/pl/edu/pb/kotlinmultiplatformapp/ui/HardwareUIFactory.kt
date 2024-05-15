package pl.edu.pb.kotlinmultiplatformapp.ui

import androidx.compose.runtime.Composable
import pl.edu.pb.androidnativeapp.ui.hardware.sensor.accelerometer.AndroidAccelerometerScreen
import pl.edu.pb.androidnativeapp.ui.hardware.sensor.light.AndroidLightScreen
import pl.edu.pb.kotlinmultiplatformapp.ui.hardware.camera.AndroidCameraScreen
import pl.edu.pb.kotlinmultiplatformapp.ui.hardware.gps.AndroidGpsScreen

class AndroidHardwareUIFactory: HardwareUIFactory {

    @Composable
    override fun CameraScreen() {
        AndroidCameraScreen()
    }

    @Composable
    override fun GpsScreen() {
        AndroidGpsScreen()
    }

    @Composable
    override fun AccelerometerScreen() {
        AndroidAccelerometerScreen()
    }

    @Composable
    override fun LightScreen() {
        AndroidLightScreen()
    }
}
