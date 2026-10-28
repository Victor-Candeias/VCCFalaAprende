package pt.vcc.falaaprende.core.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DiagnosticDao {
    @Query("SELECT COUNT(*) FROM diagnostic_entries")
    suspend fun count(): Int

    @Insert
    suspend fun insert(entry: DiagnosticEntry): Long

    @Query("DELETE FROM diagnostic_entries")
    suspend fun clear()
}
