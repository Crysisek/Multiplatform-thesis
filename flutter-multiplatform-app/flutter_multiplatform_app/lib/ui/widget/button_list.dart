import 'package:flutter/material.dart';
import 'package:flutter_multiplatform_app/navigation/destination.dart';

class ButtonList extends StatelessWidget {
  const ButtonList({super.key, required this.routes});

  final List<String> routes;

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      crossAxisAlignment: CrossAxisAlignment.center,
      children: routes.map((route) {
        return ElevatedButton(
          onPressed: () => { Navigator.pushNamed(context, route) },
          child: Text(route.getDestinationName()),
        );
      }).toList(),
    );
  }
}
