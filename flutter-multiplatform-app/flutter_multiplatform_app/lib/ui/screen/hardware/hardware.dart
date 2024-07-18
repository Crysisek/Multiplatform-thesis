import 'package:flutter/material.dart';
import 'package:flutter_multiplatform_app/navigation/destination.dart';
import 'package:flutter_multiplatform_app/ui/widget/button_list.dart';

class HardwareScreen extends StatelessWidget {
  const HardwareScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return const Scaffold(
      body: Center(
        child: ButtonList(routes: Destination.hardwareTestSubjectRoutes),
      ),
    );
  }
}
