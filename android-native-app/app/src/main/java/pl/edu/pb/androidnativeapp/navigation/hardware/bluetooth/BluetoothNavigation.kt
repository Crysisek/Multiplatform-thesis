package pl.edu.pb.androidnativeapp.navigation.hardware.bluetooth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import pl.edu.pb.androidnativeapp.navigation.Destination
import pl.edu.pb.androidnativeapp.ui.hardware.bluetooth.BluetoothScreen

fun NavGraphBuilder.bluetoothScreen() {
    composable(Destination.Hardware.Bluetooth.route) {
        BluetoothScreen()
    }
}