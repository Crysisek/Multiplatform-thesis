import 'dart:async';

import 'package:flutter/material.dart';
import 'package:geolocator/geolocator.dart';

class GpsScreen extends StatefulWidget {
  const GpsScreen({super.key});

  @override
  GpsScreenState createState() => GpsScreenState();
}

class GpsScreenState extends State<GpsScreen> {
  late String _longitude = "";
  late String _latitude = "";
  late StreamSubscription<Position> _positionStream;

  @override
  void initState() {
    super.initState();
    const LocationSettings locationSettings = LocationSettings(
      accuracy: LocationAccuracy.best,
      distanceFilter: 0,
    );
    _positionStream = Geolocator.getPositionStream(locationSettings: locationSettings).listen((Position? position) {
      setState(() {
        _longitude = position!.longitude.toString();
        _latitude = position.latitude.toString();
      });
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
            Text("Longitude: $_longitude"),
            Text("Latitude: $_latitude"),
          ],
        ),
      ),
    );
  }

  @override
  void dispose() {
    _positionStream.cancel();
    super.dispose();
  }
}
