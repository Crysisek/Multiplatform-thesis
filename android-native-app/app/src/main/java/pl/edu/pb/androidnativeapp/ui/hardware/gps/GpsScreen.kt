package pl.edu.pb.androidnativeapp.ui.hardware.gps

import android.Manifest
import android.annotation.SuppressLint
import android.location.Location
import android.os.Looper
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import kotlinx.collections.immutable.persistentListOf
import pl.edu.pb.androidnativeapp.ui.PermissionChecker

@SuppressLint("MissingPermission")
@Composable
fun GpsScreen() {
    PermissionChecker(
        permissions = persistentListOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
        ),
        onDenied = { requester ->
            LaunchedEffect(Unit) {
                requester()
            }
        },
    ) {
        val context = LocalContext.current
        val locationClient = LocationServices.getFusedLocationProviderClient(context)

        var currentLocation by remember { mutableStateOf<Location?>(null) }

        DisposableEffect(Unit) {
            val locationRequest = LocationRequest.Builder(
                Priority.PRIORITY_HIGH_ACCURACY,
                500L,
            ).build()
            val locationCallback = object : LocationCallback() {
                override fun onLocationResult(locationResult: LocationResult) {
                    for (location in locationResult.locations) {
                        currentLocation = location
                    }
                }
            }
            locationClient.requestLocationUpdates(
                locationRequest,
                locationCallback,
                Looper.getMainLooper(),
            )
            onDispose {
                locationClient.removeLocationUpdates(locationCallback)
            }
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
            ) {
                Text(text = "Longitude", fontSize = 20.sp)
                Text(text = "Latitude", fontSize = 20.sp)
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(text = "---", fontSize = 20.sp, modifier = Modifier.padding(horizontal = 10.dp))
                Text(text = "---", fontSize = 20.sp, modifier = Modifier.padding(horizontal = 10.dp))
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(text = "${currentLocation?.longitude}", fontSize = 20.sp)
                Text(text = "${currentLocation?.latitude}", fontSize = 20.sp)
            }
        }
    }
}
