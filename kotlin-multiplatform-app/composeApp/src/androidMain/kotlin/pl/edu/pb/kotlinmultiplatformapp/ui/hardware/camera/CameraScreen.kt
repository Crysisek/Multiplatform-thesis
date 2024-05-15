package pl.edu.pb.kotlinmultiplatformapp.ui.hardware.camera

import android.Manifest
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import kotlinx.collections.immutable.persistentListOf
import pl.edu.pb.kotlinmultiplatformapp.ui.common.PermissionChecker

@Composable
fun AndroidCameraScreen() {
    PermissionChecker(
        permissions = persistentListOf(Manifest.permission.CAMERA),
        onDenied = { requester ->
            LaunchedEffect(Unit) {
                requester()
            }
        },
    ) {
        val context = LocalContext.current
        val cameraController = remember {
            LifecycleCameraController(context).apply {
                setEnabledUseCases(CameraController.IMAGE_CAPTURE)
            }
        }
        CameraPreview(controller = cameraController)
    }
}
