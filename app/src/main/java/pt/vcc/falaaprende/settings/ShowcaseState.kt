package pt.vcc.falaaprende.settings

/** Regras testáveis do exemplo interativo. */
object ShowcaseState {
    fun next(current: Boolean): Boolean = !current
    fun actionLabel(selected: Boolean): String = if (selected) "Recomeçar" else "Experimentar"
}
