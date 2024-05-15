package pl.edu.pb.kotlinmultiplatformapp

import platform.UIKit.UIViewController

interface UIViewControllerFactory {

    fun makeCameraController(): UIViewController

    fun makeGpsController(): UIViewController

    fun makeAccelerometerController(): UIViewController

    fun makeLightController(): UIViewController
}
