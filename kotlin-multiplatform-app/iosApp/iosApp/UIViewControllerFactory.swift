//
//  UIViewControllerFactory.swift
//  iosApp
//
//  Created by Kacper Kalinowski on 15/05/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import ComposeApp
import UIKit
import SwiftUI

class UIViewControllerFactoryImpl: UIViewControllerFactory {
    
    func makeCameraController() -> UIViewController {
        return UIHostingController(rootView: CameraView())
    }
    
    func makeGpsController() -> UIViewController {
        return UIHostingController(rootView: GpsView())
    }
    
    func makeAccelerometerController() -> UIViewController {
        return UIHostingController(rootView: AccelerometerView())
    }
    
    func makeLightController() -> UIViewController {
        return UIHostingController(rootView: LightSensorView())
    }
}
