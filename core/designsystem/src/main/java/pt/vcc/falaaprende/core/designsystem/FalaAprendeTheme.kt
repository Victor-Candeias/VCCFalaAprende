package pt.vcc.falaaprende.core.designsystem

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val LightColors = lightColorScheme(
    primary = FalaAprendeColors.Ocean,
    onPrimary = androidx.compose.ui.graphics.Color.White,
    primaryContainer = FalaAprendeColors.Lavender,
    onPrimaryContainer = FalaAprendeColors.Ink,
    secondary = FalaAprendeColors.Mint,
    onSecondary = androidx.compose.ui.graphics.Color.White,
    tertiary = FalaAprendeColors.Coral,
    background = FalaAprendeColors.Paper,
    onBackground = FalaAprendeColors.Ink,
    surface = FalaAprendeColors.Paper,
    onSurface = FalaAprendeColors.Ink,
    surfaceVariant = FalaAprendeColors.Lavender,
    onSurfaceVariant = FalaAprendeColors.Ink
)

private val DarkColors = darkColorScheme(
    primary = FalaAprendeColors.Sunshine,
    onPrimary = FalaAprendeColors.Ink,
    secondary = androidx.compose.ui.graphics.Color(0xFF8FE1BD),
    background = FalaAprendeColors.DarkSurface,
    onBackground = androidx.compose.ui.graphics.Color.White,
    surface = FalaAprendeColors.DarkSurface,
    onSurface = androidx.compose.ui.graphics.Color.White,
    surfaceVariant = FalaAprendeColors.OceanDark,
    onSurfaceVariant = androidx.compose.ui.graphics.Color.White
)

private val ChildTypography = Typography(
    headlineMedium = Typography().headlineMedium.copy(fontWeight = FontWeight.Bold, fontSize = 30.sp),
    titleLarge = Typography().titleLarge.copy(fontWeight = FontWeight.Bold, fontSize = 23.sp),
    titleMedium = Typography().titleMedium.copy(fontWeight = FontWeight.SemiBold, fontSize = 18.sp),
    bodyLarge = Typography().bodyLarge.copy(fontSize = 18.sp, lineHeight = 27.sp)
)

@Composable
fun FalaAprendeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = ChildTypography,
        content = content
    )
}
