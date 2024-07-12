class Destination {
  // infinite list routes
  static const String infiniteListScreenRoute = '/infinite_list_screen';
  static const String infiniteListSubScreenRoute = '$infiniteListScreenRoute/sub';

  // hardware routes
  static const String hardwareScreenRoute = '/hardware_screen';
  static const String hardwareCameraScreenRoute = '$hardwareScreenRoute/camera';
  static const String hardwareGpsScreenRoute = '$hardwareScreenRoute/gps';
  static const String hardwareSensorScreenRoute = '$hardwareScreenRoute/sensor';
  static const String hardwareSensorAccelerometerScreenRoute = '$hardwareSensorScreenRoute/accelerometer';
  static const String hardwareSensorLightScreenRoute = '$hardwareSensorScreenRoute/light';
  static const List<String> hardwareSensorTestSubjectRoutes = [
    hardwareSensorAccelerometerScreenRoute,
    hardwareSensorLightScreenRoute,
  ];
  static const List<String> hardwareTestSubjectRoutes = [
    hardwareCameraScreenRoute,
    hardwareGpsScreenRoute,
    hardwareSensorScreenRoute,
  ];

  // database routes
  static const String databaseScreenRoute = '/database_screen';

  // animation routes
  static const String animationScreenRoute = '/animation_screen';

  // file decoding routes
  static const String fileDecodingScreenRoute = '/file_decoding_screen';

  // home routes
  static const List<String> homeTestSubjectRoutes = [
    infiniteListScreenRoute,
    hardwareScreenRoute,
    databaseScreenRoute,
    animationScreenRoute,
    fileDecodingScreenRoute,
  ];
}

extension DestinationName on String {
  String getDestinationName() => substring(1).replaceAll('_screen', '').replaceAll('_', ' ').replaceAll('/', ' ').toUpperCase();
}
