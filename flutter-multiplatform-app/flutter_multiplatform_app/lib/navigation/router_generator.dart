import 'package:flutter/material.dart';
import 'package:flutter_multiplatform_app/navigation/destination.dart';
import 'package:flutter_multiplatform_app/presentation/data_type_enum.dart';
import 'package:flutter_multiplatform_app/ui/screen/animation/animation.dart';
import 'package:flutter_multiplatform_app/ui/screen/database/database.dart';
import 'package:flutter_multiplatform_app/ui/screen/hardware/camera/camera.dart';
import 'package:flutter_multiplatform_app/ui/screen/hardware/gps/gps.dart';
import 'package:flutter_multiplatform_app/ui/screen/hardware/hardware.dart';
import 'package:flutter_multiplatform_app/ui/screen/hardware/sensor/accelerometer/accelerometer.dart';
import 'package:flutter_multiplatform_app/ui/screen/hardware/sensor/light/light.dart';
import 'package:flutter_multiplatform_app/ui/screen/hardware/sensor/sensor.dart';
import 'package:flutter_multiplatform_app/ui/screen/home.dart';
import 'package:flutter_multiplatform_app/ui/screen/infinitelist/infinite_list.dart';

class RouterGenerator {
  static Route<dynamic> generateRoute(RouteSettings settings) {
    final arguments = settings.arguments;
    switch (settings.name) {
      case Destination.infiniteListScreenRoute:
        return MaterialPageRoute<InfiniteListRouter>(builder: (context) => const InfiniteListRouter());

      case Destination.infiniteListSubScreenRoute:
        return MaterialPageRoute<InfiniteListScreen>(builder: (context) => InfiniteListScreen(dataTypeEnum: arguments as DataTypeEnum));

      case Destination.hardwareScreenRoute:
        return MaterialPageRoute<HardwareScreen>(builder: (context) => const HardwareScreen());

      case Destination.hardwareCameraScreenRoute:
        return MaterialPageRoute<CameraScreen>(builder: (context) => const CameraScreen());

      case Destination.hardwareGpsScreenRoute:
        return MaterialPageRoute<GpsScreen>(builder: (context) => const GpsScreen());

      case Destination.hardwareSensorScreenRoute:
        return MaterialPageRoute<SensorScreen>(builder: (context) => const SensorScreen());

      case Destination.hardwareSensorLightScreenRoute:
        return MaterialPageRoute<LightScreen>(builder: (context) => const LightScreen());

      case Destination.hardwareSensorAccelerometerScreenRoute:
        return MaterialPageRoute<AccelerometerScreen>(builder: (context) => const AccelerometerScreen());

      case Destination.databaseScreenRoute:
        return MaterialPageRoute<DatabaseScreen>(builder: (context) => const DatabaseScreen());

      case Destination.animationScreenRoute:
        return MaterialPageRoute<AnimationScreen>(builder: (context) => const AnimationScreen());

      default:
        return MaterialPageRoute<HomeScreen>(builder: (context) => const HomeScreen());
    }
  }
}
