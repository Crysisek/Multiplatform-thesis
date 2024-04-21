//
//  HardwareMenuView.swift
//  native-ios-app
//
//  Created by Aleksander Kalinowski on 21/04/2024.
//

import SwiftUI

struct HardwareMenuView: View {
    var body: some View {
        NavigationView {
            List {
                NavigationLink(destination: LightSensorView()) {
                    Button("Light") {}
                }
                NavigationLink(destination: GpsView()) {
                    Button("GPS") {}
                }
                NavigationLink(destination: CameraView()) {
                    Button("Camera") {}
                }
                NavigationLink(destination: AccelerometerView()) {
                    Button("Accelerometer") {}
                }
            }
        }
        .navigationTitle("Hardware")
    }
}

#Preview {
    HardwareMenuView()
}
