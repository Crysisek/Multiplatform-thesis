import 'dart:async';

import 'package:flutter/material.dart';
import 'package:sensors_plus/sensors_plus.dart';

class AccelerometerScreen extends StatefulWidget {
  const AccelerometerScreen({super.key});

  @override
  AccelerometerScreenState createState() => AccelerometerScreenState();
}

class AccelerometerScreenState extends State<AccelerometerScreen> {
  UserAccelerometerEvent? _accelerometerEvent;
  late StreamSubscription<dynamic> _accelerometerEventStream;

  Duration sensorInterval = SensorInterval.normalInterval;

  @override
  void initState() {
    super.initState();
    _accelerometerEventStream = userAccelerometerEventStream(samplingPeriod: sensorInterval).listen((event) {
      setState(() => _accelerometerEvent = event);
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
            Text("Force X: ${_accelerometerEvent?.x.toStringAsFixed(6) ?? ''}"),
            Text("Force Y: ${_accelerometerEvent?.y.toStringAsFixed(6) ?? ''}"),
            Text("Force Z: ${_accelerometerEvent?.z.toStringAsFixed(6) ?? ''}"),
          ],
        ),
      ),
    );
  }

  @override
  void dispose() {
    _accelerometerEventStream.cancel();
    super.dispose();
  }
}
