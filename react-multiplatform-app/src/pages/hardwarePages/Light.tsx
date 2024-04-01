import {Platform, StyleSheet, TouchableOpacity, View, Text} from "react-native";
import {useEffect, useState} from "react";
import {LightSensor} from "expo-sensors";
import type {Subscription} from "expo-sensors/src/DeviceSensor";

const Light = () => {
  const [{ illuminance }, setData] = useState({ illuminance: 0 });
  const [subscription, setSubscription] = useState<Subscription>();

  useEffect(() => {
    _toggle();

    return () => {
      _unsubscribe();
    };
  }, []);

  const _toggle = () => {
    if (subscription) {
      _unsubscribe();
    } else {
      _subscribe();
    }
  };

  const _subscribe = () => {
    setSubscription(LightSensor.addListener(setData));
  };

  const _unsubscribe = () => {
    subscription && subscription.remove();
    setSubscription(undefined);
  };

  return (
      <View style={styles.sensor}>
        <Text>Light Sensor:</Text>
        <Text>
          Illuminance: {Platform.OS === 'android' ? `${illuminance} lx` : `Only available on Android`}
        </Text>
        <View style={styles.buttonContainer}>
          <TouchableOpacity onPress={_toggle} style={styles.button}>
            <Text>Toggle</Text>
          </TouchableOpacity>
        </View>
      </View>
  );
}

const styles = StyleSheet.create({
  buttonContainer: {
    flexDirection: 'row',
    alignItems: 'stretch',
    marginTop: 15,
  },
  button: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#eee',
    padding: 10,
  },
  sensor: {
    marginTop: 45,
    paddingHorizontal: 10,
  },
});
export default Light