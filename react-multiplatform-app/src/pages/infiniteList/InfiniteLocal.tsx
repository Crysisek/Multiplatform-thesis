import {
  FlatList,
  ListRenderItem,
  StyleSheet,
  Text,
  View,
  Image,
  ActivityIndicator
} from "react-native";
import {useEffect, useState} from "react";
import {RMCharacter, RMCharacterResult, URL} from "./types";
import api from "../../config/api";
import {AxiosResponse} from "axios";

const InfiniteListLocal = () => {
  return <View style={styles.container}></View>
}

const styles = StyleSheet.create({
  container: {
    justifyContent: 'center',
    alignItems: 'center',
    width: '100%'
  },
});

export default InfiniteListLocal