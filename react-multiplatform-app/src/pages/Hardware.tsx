import {Button, StyleSheet, View} from "react-native";
import {useNavigation} from "@react-navigation/native";
import React from "react";

const Hardware = () => {
  const navigation = useNavigation();

  const buttons = [
    { id: 10, title: 'Accelerometer', routeName: 'Accelerometer' },
    { id: 20, title: 'Camera', routeName: 'Camera' },
    { id: 30, title: 'Gps', routeName: 'Gps' },
    { id: 40, title: 'Light', routeName: 'Light' },
    { id: 50, title: 'Microphone', routeName: 'Microphone' },
  ];

  const handleButtonPress = (routeName: string) => {
    navigation.navigate(routeName);
  };

  return (
      <View style={styles.container}>
        {buttons.map(button => (
            <Button
                key={button.id}
                title={button.title}
                onPress={() => handleButtonPress(button.routeName)}
            />
        ))}
      </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
});

export default Hardware