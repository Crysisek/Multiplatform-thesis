import 'dart:async';

import 'package:environment_sensors/environment_sensors.dart';
import 'package:flutter/material.dart';

class LightScreen extends StatefulWidget {
  const LightScreen({super.key});

  @override
  LightScreenState createState() => LightScreenState();
}

class LightScreenState extends State<LightScreen> {
  late double _illuminance = 0;
  late StreamSubscription<double> _lightLevelStream;

  @override
  void initState() {
    super.initState();
    _lightLevelStream = EnvironmentSensors().light.listen((lightLevel) {
      setState(() => _illuminance = lightLevel);
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            Text("Illuminance: $_illuminance"),
          ],
        ),
      ),
    );
  }

  @override
  void dispose() {
    _lightLevelStream.cancel();
    super.dispose();
  }
}
