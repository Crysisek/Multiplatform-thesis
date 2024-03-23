import { StyleSheet } from 'react-native';
import {NavigationContainer} from "@react-navigation/native";
import {createStackNavigator} from "@react-navigation/stack";
import ButtonList from "./src/pages/ButtonList";
import InfiniteList from "./src/pages/InfiniteList";
import Hardware from "./src/pages/Hardware";
import Database from "./src/pages/Database";
import Animation from "./src/pages/Animation";
import FileDecoding from "./src/pages/FileDecoding";

const Stack = createStackNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName="button-list">
        <Stack.Screen name="Button List" component={ButtonList}/>
        <Stack.Screen name="Infinite list" component={InfiniteList}/>
        <Stack.Screen name="Hardware" component={Hardware}/>
        <Stack.Screen name="Database" component={Database}/>
        <Stack.Screen name="Animation" component={Animation}/>
        <Stack.Screen name="File decoding" component={FileDecoding}/>
      </Stack.Navigator>
    </NavigationContainer>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});