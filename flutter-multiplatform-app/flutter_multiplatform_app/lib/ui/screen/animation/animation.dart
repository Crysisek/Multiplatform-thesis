import 'package:flutter/material.dart';

class AnimationScreen extends StatefulWidget {
  const AnimationScreen({super.key});

  @override
  State<AnimationScreen> createState() => AnimationScreenState();
}

class AnimationScreenState extends State<AnimationScreen> with SingleTickerProviderStateMixin {
  late final AnimationController _controller = AnimationController(
    duration: const Duration(seconds: 1),
    vsync: this,
  )..repeat(reverse: true);

  static const double rectSize = 100;
  static const Cubic linearOutSlowIn = Cubic(0.0, 0.0, 0.2, 1.0);
  static const Color magenta = Color(0xFFFF00FF);

  @override
  Widget build(BuildContext context) {
    final double height = MediaQuery.sizeOf(context).height;
    final Animation<Offset> offsetAnimation = Tween<Offset>(
      begin: Offset.zero,
      end: Offset(0.0, -(height / rectSize - 0.5) / 2),
    ).animate(CurvedAnimation(
      parent: _controller,
      curve: linearOutSlowIn,
    ));
    final Animation<Color?> colorAnimation = ColorTween(
      begin: Colors.red,
      end: magenta,
    ).animate(CurvedAnimation(
      parent: _controller,
      curve: linearOutSlowIn,
    ));

    return Scaffold(
      body: Align(
        alignment: Alignment.bottomCenter,
        child: AnimatedBuilder(
          animation: _controller,
          builder: (context, _) => SlideTransition(
            position: offsetAnimation,
            child: Container(
              height: rectSize,
              width: rectSize,
              color: colorAnimation.value,
            ),
          ),
        ),
      ),
    );
  }

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }
}
