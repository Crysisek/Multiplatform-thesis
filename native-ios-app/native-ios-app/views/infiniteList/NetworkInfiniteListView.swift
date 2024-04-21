//
//  NetworkInfiniteListView.swift
//  native-ios-app
//
//  Created by Aleksander Kalinowski on 21/04/2024.
//

import SwiftUI

struct NetworkInfiniteListView: View {
    @StateObject var characterLoader = CharacterLoader()
    
    var body: some View {
            List(characterLoader.characters, id: \.id) { character in
                HStack {
                    AsyncImage(url: URL(string: character.image) ?? URL(string: "")) { phase in
                        switch phase {
                        case .success(let image):
                            image
                                .resizable()
                                .aspectRatio(contentMode: .fill)
                                .frame(width: 100, height: 100)
                                .clipShape(Circle())
                        case .failure(_):
                            Image(systemName: "photo")
                                .resizable()
                                .aspectRatio(contentMode: .fill)
                                .frame(width: 100, height: 100)
                                .clipShape(Circle())
                        case .empty:
                            Image(systemName: "photo")
                                .resizable()
                                .aspectRatio(contentMode: .fill)
                                .frame(width: 100, height: 100)
                                .clipShape(Circle())
                        @unknown default:
                            Image(systemName: "photo")
                                .resizable()
                                .aspectRatio(contentMode: .fill)
                                .frame(width: 100, height: 100)
                                .clipShape(Circle())
                        }
                    }
                    VStack(alignment: .leading) {
                        Text(character.name)
                            .font(.title)
                        Text("Status: \(character.status.rawValue)")
                        Text("Gender: \(character.gender.rawValue)")
                        Text("Url: \(character.image)")
                    }
                }
                .padding()
                .onAppear {
                    if self.characterLoader.characters.last == characterLoader.characters.last {
                        characterLoader.loadCharacters()
                    }
                }
            }
            .onAppear {
                characterLoader.loadCharacters()
            }
        }
}

#Preview {
    NetworkInfiniteListView()
}
