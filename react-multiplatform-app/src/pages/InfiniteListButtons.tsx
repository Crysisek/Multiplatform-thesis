import {Button, StyleSheet, View} from "react-native";
import {useNavigation} from "@react-navigation/native";
import React from "react";

const InfiniteListButtons = () => {
  const navigation = useNavigation();

  const buttons = [
    { id: 12, title: 'Local', routeName: 'InfiniteListLocal' },
    { id: 11, title: 'Network', routeName: 'InfiniteListNetwork' },
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

export default InfiniteListButtons