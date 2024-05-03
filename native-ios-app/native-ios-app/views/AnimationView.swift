//
//  AnimationView.swift
//  native-ios-app
//
//  Created by Aleksander Kalinowski on 21/04/2024.
//

import SwiftUI

struct AnimationView: View {
    @State private var isAnimating = false
    
    var body: some View {
        VStack {
            Spacer()
            AnimatedSquare()
            Spacer()
        }
        .onAppear {
            self.isAnimating = true
        }
    }
}

struct AnimatedSquare: View {
    @State private var yOffset: CGFloat = 0
    @State private var color: Color = .pink
    
    let animationDuration: Double = 0.5
    
    var body: some View {
        Rectangle()
            .fill(color)
            .frame(width: 100, height: 100)
            .offset(y: yOffset)
            .onAppear {
                self.animate()
            }
    }
    
    func animate() {
        withAnimation(Animation.easeInOut(duration: animationDuration).repeatForever(autoreverses: true)) {
            self.yOffset = 250
        }
        
        withAnimation(Animation.easeInOut(duration: animationDuration).repeatForever(autoreverses: true).delay(animationDuration / 2)) {
            self.color = .red
        }
    }
}



#Preview {
    AnimationView()
}
