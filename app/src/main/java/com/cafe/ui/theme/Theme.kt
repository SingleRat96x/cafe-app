import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.isSystemInDarkTheme

private val LightColors = lightColorScheme(
    primary = CafeBrown,
    secondary = CafeGreen,
    surface = Background,
    background = Background,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = OnBackground,
    onSurface = OnBackground,
)

@Composable
fun CafeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = Typography,
        content = content
    )
} 