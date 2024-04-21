//
//  types.swift
//  native-ios-app
//
//  Created by Aleksander Kalinowski on 21/04/2024.
//

import Foundation

struct RMCharacter: Codable, Equatable {
    let id: Int
    let name: String
    let status: RMCharacterStatus
    let type: String
    let image: String
    let gender: RMCharacterGender
    
    static func == (lhs: RMCharacter, rhs: RMCharacter) -> Bool {
            return lhs.id == rhs.id
        }
}

enum RMCharacterGender: String, Codable {
    case Female
    case Male
    case Genderless
    case unknown
}

enum RMCharacterStatus: String, Codable {
    case Alive
    case Dead
    case unknown
}

struct RMCharacterResult: Codable {
    let info: RMCharacterInfo
    let results: [RMCharacter]
}

struct RMCharacterInfo: Codable {
    let count: Int
    let pages: Int
    let next: String
}
