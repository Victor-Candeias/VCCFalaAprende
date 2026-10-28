package pt.vcc.falaaprende.navigation

/** Texto acessível que identifica a seleção do separador. */
fun navigationStateDescription(destination: AppDestination, selected: Boolean): String =
    if (selected) "${destination.label}, selecionado" else destination.label
