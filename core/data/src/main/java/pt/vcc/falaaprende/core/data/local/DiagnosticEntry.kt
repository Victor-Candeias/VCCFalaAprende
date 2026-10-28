package pt.vcc.falaaprende.core.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/** Registo técnico sem dados pessoais ou de crianças. */
@Entity(tableName = "diagnostic_entries")
data class DiagnosticEntry(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val label: String = "Teste local"
)
