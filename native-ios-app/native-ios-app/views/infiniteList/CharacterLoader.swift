//
//  CharacterLoader.swift
//  native-ios-app
//
//  Created by Aleksander Kalinowski on 21/04/2024.
//

import Foundation

class CharacterLoader: ObservableObject {
    @Published var characters: [RMCharacter] = []
    private var nextPageURL: String?
    @Published var fetching: Bool = false
    
    func loadCharacters() {
        self.fetching = true
        guard let url = URL(string: nextPageURL ?? "https://rickandmortyapi.com/api/character/") else { return }
        
        URLSession.shared.dataTask(with: url) { data, response, error in
            guard let data = data else { return }
            
            if let decodedResponse = try? JSONDecoder().decode(RMCharacterResult.self, from: data) {
                DispatchQueue.main.async {
                    self.characters += decodedResponse.results
                    self.nextPageURL = decodedResponse.info.next
                    self.fetching = false
                }
            }
        }.resume()
    }
}
