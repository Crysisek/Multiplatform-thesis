import React, {useEffect, useState} from 'react';
import {Button, Image, StyleSheet, Text, View} from 'react-native';
import {Camera as ExpoCamera, CameraType} from 'expo-camera';

const Camera = () => {
  const [hasCameraPermission, setHasCameraPermission] = useState<boolean>(false);
  const [camera, setCamera] = useState<any>(null);
  const [image, setImage] = useState(null);
  const [type, setType] = useState<CameraType>(CameraType.back);
  useEffect(() => {
    (async () => {
      const cameraStatus = await ExpoCamera.requestCameraPermissionsAsync();
      setHasCameraPermission(cameraStatus.status === 'granted');
    })();
  }, []);
  const takePicture = async () => {
    if (camera) {
      const data = await camera.takePictureAsync(null)
      setImage(data.uri);
    }
  }

  if (!hasCameraPermission) {
    return <Text>No access to camera</Text>;
  }
  return (
      <View style={{flex: 1}}>
        <View style={styles.cameraContainer}>
          <ExpoCamera
              ref={ref => setCamera(ref)}
              style={styles.fixedRatio}
              type={type}
              ratio={'1:1'}/>
        </View>
        <Button
            title="Flip Image"
            onPress={() => {
              setType(type === CameraType.back ? CameraType.front : CameraType.back
              );
            }}>
        </Button>
        <Button title="Take Picture" onPress={() => takePicture()}/>
        {image && <Image source={{uri: image}} style={{flex: 1}}/>}
      </View>
  );
}
const styles = StyleSheet.create({
  cameraContainer: {
    flex: 1,
    flexDirection: 'row'
  },
  fixedRatio: {
    flex: 1,
    aspectRatio: 1
  }
})
export default Camera