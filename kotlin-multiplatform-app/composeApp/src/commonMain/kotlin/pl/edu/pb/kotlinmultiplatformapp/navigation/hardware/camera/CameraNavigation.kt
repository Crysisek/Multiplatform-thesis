package pl.edu.pb.kotlinmultiplatformapp.navigation.hardware.camera

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.koin.compose.koinInject
import pl.edu.pb.kotlinmultiplatformapp.navigation.Destination
import pl.edu.pb.kotlinmultiplatformapp.ui.HardwareUIFactory

fun NavGraphBuilder.cameraScreen() {
    composable(Destination.Hardware.Camera.route) {
        koinInject<HardwareUIFactory>().CameraScreen()
    }
}
