package pl.edu.pb.androidnativeapp.navigation.hardware.camera

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import pl.edu.pb.androidnativeapp.navigation.Destination
import pl.edu.pb.androidnativeapp.ui.hardware.camera.CameraScreen

fun NavGraphBuilder.cameraScreen() {
    composable(Destination.Hardware.Camera.route) {
        CameraScreen()
    }
}
