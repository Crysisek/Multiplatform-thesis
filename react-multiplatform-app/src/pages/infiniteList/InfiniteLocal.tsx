import {
  FlatList,
  ListRenderItem,
  StyleSheet,
  Text,
  View,
  Image, ActivityIndicator,
} from "react-native";
import {useEffect, useState} from "react";
import {RMCharacter, RMCharacterResult, URL} from "./types";
import api from "../../config/api";
import {AxiosResponse} from "axios";

const InfiniteListLocal = () => {

  const [characters, setCharacters] = useState<RMCharacter[]>([])
  const [loading, setLoading] = useState<boolean>(true)

  useEffect(() => {
    (async () => {
      let url = URL
      setLoading(true)
      for(let i = 0; i < 10; i ++) {
        const response: AxiosResponse<RMCharacterResult> = await api.get(url)
        const characterResult: RMCharacterResult = response.data
        url = characterResult.info.next
        setCharacters(prevState => [...prevState, ...characterResult.results])
      }
      setLoading(false)
    })()
  }, []);

  const item: ListRenderItem<RMCharacter> = ({item}) => <View style={styles.cardContainer}>
    <View style={styles.imageContainer}>
      <Image source={{ uri: item.image }} style={styles.image} />
    </View>
    <View style={styles.infoContainer}>
      <Text style={styles.name}>{item.name}</Text>
      <Text style={styles.gender}>{item.gender}</Text>
      <Text style={styles.location}>{item.status}</Text>
      <Text style={styles.location}>{item.type}</Text>
    </View>
  </View>

  if (loading) {
    return <View style={{ paddingVertical: 20 }}>
      <ActivityIndicator animating size="large" color="#007AFF" />
    </View>
  }

  return <FlatList data={characters} renderItem={item} keyExtractor={({id}) => id.toString() + Math.random()}
                  onEndReachedThreshold={0.5} />
}

const styles = StyleSheet.create({
  container: {
    justifyContent: 'center',
    alignItems: 'center',
    width: '100%'
  },
  cardContainer: {
    flexDirection: 'row',
    padding: 10,
    borderBottomWidth: 1,
    borderBottomColor: '#ccc',
  },
  imageContainer: {
    marginRight: 10,
  },
  image: {
    width: 80,
    height: 80,
    borderRadius: 5,
  },
  infoContainer: {
    flex: 1,
  },
  name: {
    fontSize: 16,
    fontWeight: 'bold',
    marginBottom: 5,
  },
  gender: {
    fontSize: 14,
    marginBottom: 5,
  },
  location: {
    fontSize: 14,
  },
});


export default InfiniteListLocal