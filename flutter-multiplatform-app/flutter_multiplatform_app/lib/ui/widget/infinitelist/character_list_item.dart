import 'package:flutter/material.dart';
import 'package:flutter_multiplatform_app/model/character.dart';

class CharacterListItem extends StatelessWidget {
  const CharacterListItem({required this.character, super.key});

  final Character character;

  @override
  Widget build(BuildContext context) {
    return Material(
      child: Row(
        children: [
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: ClipRRect(
              borderRadius: BorderRadius.circular(4.0),
              child: Image.network(
                character.image,
                fit: BoxFit.cover,
                width: 100.0,
                height: 100.0,
              ),
            ),
          ),
          Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text(character.name),
              Text(character.status),
              Text(character.species),
              Text(character.gender),
            ],
          ),
        ],
      ),
    );
  }
}
