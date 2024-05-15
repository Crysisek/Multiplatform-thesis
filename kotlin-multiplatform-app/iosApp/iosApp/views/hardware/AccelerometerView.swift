//
//  AccelerometerView.swift
//  native-ios-app
//
//  Created by Aleksander Kalinowski on 21/04/2024.
//

import SwiftUI
import CoreMotion

struct AccelerometerView: View {
    @State private var motionManager = CMMotionManager()
        @State private var accelerationX: Double = 0.0
        @State private var accelerationY: Double = 0.0
        @State private var accelerationZ: Double = 0.0
        
        var body: some View {
            VStack {
                Text("Akcelerometer")
                    .font(.title)
                    .padding()
                Text("X: \(accelerationX)")
                    .padding()
                Text("Y: \(accelerationY)")
                    .padding()
                Text("Z: \(accelerationZ)")
                    .padding()
            }
            .onAppear {
                startAccelerometer()
            }
            .onDisappear {
                stopAccelerometer()
            }
        }
        
        func startAccelerometer() {
            if motionManager.isAccelerometerAvailable {
                motionManager.accelerometerUpdateInterval = 0.1
                motionManager.startAccelerometerUpdates(to: .main) { (data, error) in
                    guard let accelerometerData = data else { return }
                    accelerationX = accelerometerData.acceleration.x
                    accelerationY = accelerometerData.acceleration.y
                    accelerationZ = accelerometerData.acceleration.z
                }
            } else {
                print("Accelerometer is not availavle")
            }
        }
        
        func stopAccelerometer() {
            motionManager.stopAccelerometerUpdates()
        }
}

#Preview {
    AccelerometerView()
}
