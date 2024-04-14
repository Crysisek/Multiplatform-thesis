package pl.edu.pb.androidnativeapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import pl.edu.pb.androidnativeapp.data.model.CharacterEntity

@Database(entities = [CharacterEntity::class], version = 1)
abstract class CharacterDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}
