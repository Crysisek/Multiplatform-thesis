//
//  ContentView.swift
//  native-ios-app
//
//  Created by Aleksander Kalinowski on 16/04/2024.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        NavigationView {
            List {
                NavigationLink(destination: InfiniteListMenuView()) {
                    Button("InfiniteList") {}
                }
                NavigationLink(destination: HardwareMenuView()) {
                    Button("Sensors") {}
                }
                NavigationLink(destination: DatabaseView()) {
                    Button("Database") {}
                }
                NavigationLink(destination: AnimationView()){
                    Button("Animation") {}
                }
            }
        }.navigationTitle("Ios test")
    }
}

#Preview {
    ContentView()
}
