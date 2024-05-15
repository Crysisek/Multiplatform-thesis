package pl.edu.pb.kotlinmultiplatformapp.extensions

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp

data class ScreenSizeInfo(val screenHeightPx: Int, val screenWidthPx: Int)

@Composable
expect fun getScreenSizeInfo(): ScreenSizeInfo
