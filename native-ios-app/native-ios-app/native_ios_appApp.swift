//
//  native_ios_appApp.swift
//  native-ios-app
//
//  Created by Aleksander Kalinowski on 16/04/2024.
//

import SwiftUI
import CoreData

@main
struct native_ios_appApp: App {
    
    @StateObject private var manager: DataManager = DataManager()
    
    var body: some Scene {
        WindowGroup {
            ContentView()
                .environmentObject(manager)
                .environment(\.managedObjectContext, manager.container.viewContext)
        }
    }
}
