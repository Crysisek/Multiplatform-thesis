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

const InfiniteList = () => {

  const [characters, setCharacters] = useState<RMCharacter[]>([])
  const [nextUrl, setNextUrl] = useState<string>(URL)
  const [isLoading, setIsLoading] = useState<boolean>(false)

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

  useEffect(() => {
    (async () => handleEndReach())()
  }, []);

  const handleEndReach = async (): Promise<void> => {
    setIsLoading(true)
    const response: AxiosResponse<RMCharacterResult> = await api.get(nextUrl)
    const characterResult: RMCharacterResult = response.data
    setNextUrl(characterResult.info.next)
    setCharacters(prevState => [...prevState, ...characterResult.results])
    setIsLoading(false)
  }

  const renderFooter = () => {
    if (!isLoading) return null;

    return (
        <View style={{ paddingVertical: 20 }}>
          <ActivityIndicator animating size="large" color="#007AFF" />
        </View>
    );
  };

  return <FlatList data={characters} renderItem={item} keyExtractor={({id}) => id.toString() + Math.random()}
              onEndReached={handleEndReach} onEndReachedThreshold={0.5} ListFooterComponent={renderFooter} />
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

export default InfiniteList