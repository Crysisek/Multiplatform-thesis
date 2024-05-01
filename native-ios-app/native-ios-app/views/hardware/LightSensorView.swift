//
//  LightSensorView.swift
//  native-ios-app
//
//  Created by Aleksander Kalinowski on 21/04/2024.
//

import SwiftUI

struct LightSensorView: View {
        @State private var lightLevel: Float = 0.0
        
        var body: some View {
            VStack {
                Text("Light level:")
                    .font(.title)
                    .padding()
                Text("\(lightLevel)")
                    .font(.title)
                    .padding()
            }
            .onAppear {
                self.getLightLevel()
            }
        }
        
        func getLightLevel() {
            self.lightLevel = Float(UIScreen.main.brightness)
        }
}

#Preview {
    LightSensorView()
}
