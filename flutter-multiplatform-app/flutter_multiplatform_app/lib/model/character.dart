import 'package:equatable/equatable.dart';

final class Character extends Equatable {
  const Character({
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

  @override
  List<Object> get props => [id, name, status, species, gender, image];
}
