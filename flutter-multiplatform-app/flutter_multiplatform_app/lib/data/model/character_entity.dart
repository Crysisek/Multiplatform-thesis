final class CharacterEntity {
  const CharacterEntity({
    required this.id,
    required this.name,
    required this.status,
    required this.species,
    required this.gender,
    required this.image,
  });

  final int id;
  final String name;
  final String status;
  final String species;
  final String gender;
  final String image;

  CharacterEntity.fromJson(Map<String, dynamic> json)
      : id = json['id'] as int,
        name = json['name'] as String,
        status = json['status'] as String,
        species = json['species'] as String,
        gender = json['gender'] as String,
        image = json['image'] as String;

  // Convert a CharacterEntity into a Map. The keys must correspond to the names of the columns in the database.
  Map<String, Object?> toMap() {
    return {
      'id': id,
      'name': name,
      'status': status,
      'species': species,
      'gender': gender,
      'image': image,
    };
  }
}
