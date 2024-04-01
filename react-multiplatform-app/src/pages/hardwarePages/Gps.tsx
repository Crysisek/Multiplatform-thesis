import {StyleSheet, Text, View} from "react-native";
import {useEffect, useState} from "react";
import * as Location from 'expo-location';

const Gps = () => {

  const [location , setLocation] = useState<Location.LocationGeocodedAddress>()

  useEffect(() => {
    const getLocation = async () => {
      try {
        let { status } = await Location.requestForegroundPermissionsAsync();

        if (status !== "granted") {
          return;
        }

        const location = await Location.getCurrentPositionAsync({});
        const result = await Location.reverseGeocodeAsync(location.coords)
        setLocation(result[0])
      } catch (error) {
        console.error("Error requesting location permission:", error);
      }
    };

    getLocation();
  }, []);


  return <View style={styles.container}>
    <Text>{location?.name}</Text>
    <Text>{location?.city}</Text>
    <Text>{location?.country}</Text>
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