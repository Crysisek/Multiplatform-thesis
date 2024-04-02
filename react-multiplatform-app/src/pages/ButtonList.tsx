import {useNavigation} from "@react-navigation/native";
import React from "react";
import {Button, StyleSheet, View} from "react-native";

const ButtonList = () => {
  const navigation = useNavigation();

  const buttons = [
    { id: 1, title: 'Infinite list', routeName: 'Infinite list' },
    { id: 2, title: 'Sensors', routeName: 'Hardware' },
    { id: 3, title: 'Database', routeName: 'Database' },
    { id: 4, title: 'Animation', routeName: 'Animation' },
    { id: 5, title: 'File decoding', routeName: 'File decoding' },
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
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
});

export default ButtonList;