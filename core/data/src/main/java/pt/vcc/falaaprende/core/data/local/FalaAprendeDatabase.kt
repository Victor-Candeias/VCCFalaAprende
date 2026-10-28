package pt.vcc.falaaprende.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DiagnosticEntry::class], version = 1, exportSchema = false)
abstract class FalaAprendeDatabase : RoomDatabase() {
    abstract fun diagnosticDao(): DiagnosticDao
}
