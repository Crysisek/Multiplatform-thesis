package pl.edu.pb.androidnativeapp.navigation.hardware

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import pl.edu.pb.androidnativeapp.navigation.Destinations
import pl.edu.pb.androidnativeapp.navigation.hardware.bluetooth.bluetoothScreen
import pl.edu.pb.androidnativeapp.navigation.hardware.camera.cameraScreen
import pl.edu.pb.androidnativeapp.navigation.hardware.gps.gpsScreen
import pl.edu.pb.androidnativeapp.navigation.hardware.nfc.nfcScreen
import pl.edu.pb.androidnativeapp.ui.hardware.HardwareScreen

fun NavGraphBuilder.hardwareScreen(navigateTo: (String) -> Unit) {
    composable(Destinations.Hardware.route) {
        HardwareScreen(navigateTo = navigateTo)
    }
    cameraScreen()
    gpsScreen()
    bluetoothScreen()
    nfcScreen()
}
