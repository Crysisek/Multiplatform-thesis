import 'package:flutter/material.dart';
import 'package:flutter_multiplatform_app/di/get_it.dart';
import 'package:flutter_multiplatform_app/navigation/router_generator.dart';

void main() {
  WidgetsFlutterBinding.ensureInitialized();
  setupGetIt();
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
        // https://github.com/flutter/flutter/issues/145894
        // https://main-api.flutter.dev/flutter/material/ZoomPageTransitionsBuilder/allowSnapshotting.html
        pageTransitionsTheme: const PageTransitionsTheme(
          builders: <TargetPlatform, PageTransitionsBuilder>{
            TargetPlatform.android: ZoomPageTransitionsBuilder(
              allowSnapshotting: false,
            ),
          },
        ),
      ),
      onGenerateRoute: RouterGenerator.generateRoute,
    );
  }
}
