import {openDatabase} from 'expo-sqlite';
import {RMCharacter} from "../pages/infiniteList/types";

// Inicjalizacja bazy danych
const db = openDatabase('RMCharacters.db');

// Tworzenie tabeli
db.transaction(tx => {
  tx.executeSql(
      'CREATE TABLE IF NOT EXISTS characters (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, status TEXT, type TEXT, image TEXT, gender TEXT)',
      [],
      () => {},
  );
});

// Funkcja obsługująca dodawanie tablicy postaci
export const insertCharacters = (characters: RMCharacter[], onSuccess: () => void) => {
  db.transaction(
      tx => {
        characters.forEach(character => {
          tx.executeSql(
              'INSERT INTO characters (name, status, type, image, gender) VALUES (?, ?, ?, ?, ?)',
              [character.name, character.status, character.type, character.image, character.gender],
              (_, results) => {
                console.log('Character inserted successfully');
              },
          );
        });
      },
      () => {},
      onSuccess
  );
};

export const getAllCharacters = (callback: (values: RMCharacter[]) => void) => {
  db.transaction(
      tx => {
        tx.executeSql(
            'SELECT * FROM characters',
            [],
            (_, results) => {
              const characters = results.rows._array;
              callback(characters);
            },
        );
      },
  );
};