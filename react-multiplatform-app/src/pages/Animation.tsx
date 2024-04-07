import React, { useRef, useEffect } from 'react';
import { Animated, View, StyleSheet } from 'react-native';


const Animation = () => {
  const bounceValue = useRef(new Animated.Value(0)).current;

  useEffect(() => {
    const bounceUpAnimation = Animated.timing(
        bounceValue,
        {
          toValue: 1,
          duration: 1000, // czas podskoku w ms
          useNativeDriver: true,
        }
    );

    const bounceDownAnimation = Animated.timing(
        bounceValue,
        {
          toValue: 0,
          duration: 1000,
          useNativeDriver: true,
        }
    );

    const bounceAnimation = Animated.sequence([
      bounceUpAnimation,
      bounceDownAnimation
    ]);

    const loopAnimation = Animated.loop(bounceAnimation);

    loopAnimation.start();

    return () => {
      loopAnimation.stop();
    };
  }, [bounceValue]);

  const interpolateDown = bounceValue.interpolate({
    inputRange: [0, 1],
    outputRange: [1, 5],
    extrapolate: 'clamp'
  });

  const interpolateUp = bounceValue.interpolate({
    inputRange: [0, 0.5, 1],
    outputRange: [10, 1, 10],
    extrapolate: 'clamp'
  });

  const interpolateColor = bounceValue.interpolate({
    inputRange: [0, 1],
    outputRange: ['red', 'rgba(255,105,180,1)'],
    extrapolate: 'clamp'
  });

  const interpolatedValue = Animated.add(
      Animated.multiply(interpolateUp, interpolateDown),
      bounceValue.interpolate({
        inputRange: [0, 1],
        outputRange: [0, 250],
        extrapolate: 'clamp'
      })
  );

  return (
      <View style={styles.container}>
        <Animated.View
            style={[
              styles.square,
              {
                transform: [{ translateY: interpolatedValue }],
                backgroundColor: interpolateColor
              }
            ]}
        />
      </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  square: {
    width: 100,
    height: 100,
    backgroundColor: 'blue',
  },
});



export default Animation