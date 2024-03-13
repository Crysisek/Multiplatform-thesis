package pl.edu.pb.androidnativeapp.ui.hardware.camera

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import pl.edu.pb.androidnativeapp.ui.PermissionChecker

@Composable
fun CameraScreen() {
    val context = LocalContext.current
    val cameraController = remember {
        LifecycleCameraController(context).apply {
            setEnabledUseCases(CameraController.IMAGE_CAPTURE)
        }
    }
    PermissionChecker(
        permission = Manifest.permission.CAMERA,
        onDenied = { requester ->
            LaunchedEffect(Unit) {
                requester()
            }
        },
    ) {
        CameraPreview(controller = cameraController)
    }
}
