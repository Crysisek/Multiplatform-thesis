//
//  DatabaseView.swift
//  native-ios-app
//
//  Created by Aleksander Kalinowski on 21/04/2024.
//

import SwiftUI

struct DatabaseView: View {
    @StateObject var characterLoader = CharacterLoader()
    @EnvironmentObject var manager: DataManager
    @Environment(\.managedObjectContext) var viewContext
    @State var isLoading: Bool = false
    @State var characters: [Character] = []
    
    var body: some View {
        VStack{
            Button("FetchData") {
                loadCharacters()
            }
            .disabled(isLoading || characterLoader.fetching)
            Spacer()
            Button("Load from db") {
                loadFromDB()
            }.disabled(isLoading || characterLoader.fetching)
            Spacer()
            if (isLoading || characterLoader.fetching) {
                Text("Loading")
            }
            Spacer()
            List(characters, id: \.id) { (character: Character) in
                HStack {
                    if let imageURL = URL(string: character.image ?? "") {
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
                        Text(character.name ?? "")
                            .font(.title)
                        Text("Status: \(String(describing: character.status))")
                        Text("Gender: \(String(describing: character.gender))")
                    }
                }
                .padding()
            }
        }.onAppear{loadFromNetwork()}
    }
    
    func loadFromNetwork() {
        for _ in 0..<10 {
            characterLoader.loadCharacters()
        }
    }
    
    func loadCharacters() {
        self.isLoading = true
        DispatchQueue.global().async {
            let tempChar: [RMCharacter] = characterLoader.characters
                tempChar.forEach { character in
                    let toSave: Character = Character(context:viewContext)
                    toSave.id = Int32(character.id)
                    toSave.gender = character.gender.rawValue
                    toSave.image = character.image
                    toSave.name = character.name
                    toSave.status = character.status.rawValue
                    toSave.type = character.type
                    
                    do {
                        try viewContext.save()
                        print("Character with id \(toSave.id) saved")
                    } catch {
                        print ("Ops, error saving character with id: \(toSave.id)")
                    }
                    
                }
        }
            
        DispatchQueue.main.async {
            self.isLoading = false
        }

    }
    
    func loadFromDB() {
        self.isLoading = true
        DispatchQueue.global().async {
            do {
                characters = try viewContext.fetch(Character.fetchRequest())
            } catch{
                print("Error loading from DB")
            }}
        DispatchQueue.main.async {
            self.isLoading = false
        }
    }
}

#Preview {
    DatabaseView()
}
