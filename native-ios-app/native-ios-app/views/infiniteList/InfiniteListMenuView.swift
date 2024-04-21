//
//  InfiniteListMenuView.swift
//  native-ios-app
//
//  Created by Aleksander Kalinowski on 21/04/2024.
//

import SwiftUI

struct InfiniteListMenuView: View {
    var body: some View {
        NavigationView {
            List {
                NavigationLink(destination: LocalInfiniteListView()) {
                    Button("Local") {}
                }
                NavigationLink(destination: NetworkInfiniteListView()) {
                    Button("Network") {}
                }
            }
        }
        .navigationTitle("Infinite list")
    }
}

#Preview {
    InfiniteListMenuView()
}
