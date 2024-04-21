//
//  LocalInfiniteListView.swift
//  native-ios-app
//
//  Created by Aleksander Kalinowski on 21/04/2024.
//

import SwiftUI

struct LocalInfiniteListView: View {
    @StateObject var characterLoader = CharacterLoader()
    @State private var characters: [RMCharacter] = []
    @State private var isLoading = true
        
        var body: some View {
            List(characters, id: \.id) { character in
                HStack {
                    if let imageURL = URL(string: character.image) {
                        AsyncImage(url: imageURL) { phase in
                            switch phase {
                            case .success(let image):
                                image
                                    .resizable()
                                    .aspectRatio(contentMode: .fill)
                                    .frame(width: 100, height: 100)
                                    .clipShape(Circle())
                            default:
                                Image(systemName: "photo")
                                    .resizable()
                                    .aspectRatio(contentMode: .fill)
                                    .frame(width: 100, height: 100)
                                    .clipShape(Circle())
                            }
                        }
                    } else {
                        Image(systemName: "photo")
                            .resizable()
                            .aspectRatio(contentMode: .fill)
                            .frame(width: 100, height: 100)
                            .clipShape(Circle())
                    }
                    
                    VStack(alignment: .leading) {
                        Text(character.name)
                            .font(.title)
                        Text("Status: \(character.status.rawValue)")
                        Text("Gender: \(character.gender.rawValue)")
                    }
                }
                .padding()
            }
            .onAppear {
                loadCharacters()
            }
        }
        
        func loadCharacters() {
            isLoading = true
            for _ in 0..<10 {
                characterLoader.loadCharacters()
            }
            
            DispatchQueue.main.asyncAfter(deadline: .now() + 5) {
                characters = characterLoader.characters
                isLoading = false
            }
        }
}

#Preview {
    LocalInfiniteListView()
}
