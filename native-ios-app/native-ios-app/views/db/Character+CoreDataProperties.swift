//
//  Character+CoreDataProperties.swift
//  native-ios-app
//
//  Created by Aleksander Kalinowski on 03/05/2024.
//
//

import Foundation
import CoreData


extension Character {

    @nonobjc public class func fetchRequest() -> NSFetchRequest<Character> {
        return NSFetchRequest<Character>(entityName: "Character")
    }

    @NSManaged public var id: Int32
    @NSManaged public var name: String?
    @NSManaged public var status: String?
    @NSManaged public var type: String?
    @NSManaged public var image: String?
    @NSManaged public var gender: String?

}

extension Character : Identifiable {

}

// Main data manager to handle the todo items
class DataManager: NSObject, ObservableObject {
    
    @Published var characters: [Character] = [Character]()
    
    // Add the Core Data container with the model name
    let container: NSPersistentContainer = NSPersistentContainer(name: "Character")
    
    // Default init method. Load the Core Data container
    override init() {
        super.init()
        container.loadPersistentStores { _, _ in }
    }
}
