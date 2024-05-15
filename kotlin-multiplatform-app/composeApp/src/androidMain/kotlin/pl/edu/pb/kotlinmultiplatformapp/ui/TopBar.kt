package pl.edu.pb.kotlinmultiplatformapp.ui

import androidx.compose.runtime.Composable

@Composable
actual fun TopBar(onClick: () -> Unit) = Unit // We do not want TopBar for Android
