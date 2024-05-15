package pl.edu.pb.kotlinmultiplatformapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitViewController
import kotlinx.cinterop.ExperimentalForeignApi
import pl.edu.pb.kotlinmultiplatformapp.UIViewControllerFactory
import pl.edu.pb.kotlinmultiplatformapp.navigation.Destination

class IOSHardwareUIFactory(private val uiViewControllerFactory: UIViewControllerFactory) : HardwareUIFactory {

    @Composable
    override fun CameraScreen() {
        UI(Destination.Hardware.Camera)
    }

    @Composable
    override fun GpsScreen() {
        UI(Destination.Hardware.Gps)
    }

    @Composable
    override fun AccelerometerScreen() {
        UI(Destination.Hardware.Sensor.Accelerometer)
    }

    @Composable
    override fun LightScreen() {
        UI(Destination.Hardware.Sensor.Light)
    }

    @OptIn(ExperimentalForeignApi::class)
    @Composable
    private fun UI(destination: Destination) {
        val controller = when (destination) {
            Destination.Hardware.Camera -> {
                uiViewControllerFactory.makeCameraController()
            }

            Destination.Hardware.Gps -> {
                uiViewControllerFactory.makeGpsController()
            }

            Destination.Hardware.Sensor.Accelerometer -> {
                uiViewControllerFactory.makeAccelerometerController()
            }

            Destination.Hardware.Sensor.Light -> {
                uiViewControllerFactory.makeLightController()
            }

            else -> uiViewControllerFactory.makeCameraController()
        }
        UIKitViewController(
            factory = { controller },
            modifier = Modifier.fillMaxSize(),
        )
    }
}
