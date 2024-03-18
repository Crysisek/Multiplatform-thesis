package pl.edu.pb.androidnativeapp.ui

import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import kotlinx.collections.immutable.ImmutableList

/**
 * Composable helper for permission checking.
 *
 * onDenied contains lambda for request permission
 *
 * @param permissions permissions for request
 * @param onDenied composable for [PackageManager.PERMISSION_DENIED]
 * @param onGranted composable for [PackageManager.PERMISSION_GRANTED]
 */
@Composable
fun PermissionChecker(
    permissions: ImmutableList<String>,
    onDenied: @Composable (requester: () -> Unit) -> Unit,
    onGranted: @Composable () -> Unit,
) {
    val context = LocalContext.current
    var isPermissionGranted by remember {
        mutableStateOf(checkPermission(context, permissions))
    }
    if (isPermissionGranted) {
        onGranted()
    } else {
        val permissionRequest = rememberLauncherForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions(),
        ) { permissions ->
            isPermissionGranted = permissions.values.reduce { acc, isPermissionGranted ->
                acc && isPermissionGranted
            }
        }
        onDenied {
            permissionRequest.launch(permissions.toTypedArray())
        }
    }
}

private fun checkPermission(context: Context, permissions: List<String>): Boolean {
    return permissions.all { permission ->
        ContextCompat.checkSelfPermission(
            context,
            permission,
        ) == PackageManager.PERMISSION_GRANTED
    }
}
