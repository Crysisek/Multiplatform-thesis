import { StyleSheet } from 'react-native';
import {NavigationContainer} from "@react-navigation/native";
import {createStackNavigator} from "@react-navigation/stack";
import ButtonList from "./src/pages/ButtonList";
import Hardware from "./src/pages/Hardware";
import Database from "./src/pages/Database";
import Animation from "./src/pages/Animation";
import FileDecoding from "./src/pages/FileDecoding";
import Accelerometer from "./src/pages/hardwarePages/Accelerometer";
import Camera from "./src/pages/hardwarePages/Camera";
import Gps from "./src/pages/hardwarePages/Gps";
import Light from "./src/pages/hardwarePages/Light";
import InfiniteListButtons from "./src/pages/InfiniteListButtons";
import InfiniteList from "./src/pages/infiniteList/InfiniteList";
import InfiniteListLocal from "./src/pages/infiniteList/InfiniteLocal";

const Stack = createStackNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName="button-list">
        <Stack.Screen name="Button List" component={ButtonList}/>
        <Stack.Screen name="InfiniteListButtons" component={InfiniteListButtons}/>
        <Stack.Screen name="Hardware" component={Hardware}/>
        <Stack.Screen name="Database" component={Database}/>
        <Stack.Screen name="Animation" component={Animation}/>
        <Stack.Screen name="File decoding" component={FileDecoding}/>
        <Stack.Screen name="Accelerometer" component={Accelerometer}/>
        <Stack.Screen name="Camera" component={Camera}/>
        <Stack.Screen name="Gps" component={Gps}/>
        <Stack.Screen name="Light" component={Light}/>
        <Stack.Screen name="InfiniteListLocal" component={InfiniteListLocal}/>
        <Stack.Screen name="InfiniteListNetwork" component={InfiniteList}/>
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
