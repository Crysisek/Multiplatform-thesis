import {StyleSheet, Text, View} from "react-native";
import {useEffect, useState} from "react";
import * as Location from 'expo-location';

const Gps = () => {

  const [location , setLocation] = useState<Location.LocationObject>()

  useEffect(() => {
    const getLocation = async () => {
      try {
        let { status } = await Location.requestForegroundPermissionsAsync();

        if (status !== "granted") {
          return;
        }

        const location = await Location.getCurrentPositionAsync({});
        setLocation(location)
      } catch (error) {
        console.error("Error requesting location permission:", error);
      }
    };

    getLocation();
  }, []);


  return <View style={styles.container}>
    <Text>{`longitude: ${location?.coords.longitude}`}</Text>
    <Text>{`altitude: ${location?.coords.altitude}`}</Text>
  </View>
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
});

export default Gps