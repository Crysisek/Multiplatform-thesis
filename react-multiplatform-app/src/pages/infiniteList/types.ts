export const URL = 'https://rickandmortyapi.com/api/character'

export type RMCharacter = {
  id: number
  name: string
  status: RMCharacterStatus
  type: string
  image: string
  gender: RMCharacterGender
}

export type RMCharacterResult = {
  info: {
    count: number
    pages: number
    next: string
  },
  results: RMCharacter[]
}

type RMCharacterStatus = "Alive" | "Dead" | "unknown"
type RMCharacterGender = "Female" | "Male" | 'Genderless' | "unknown"