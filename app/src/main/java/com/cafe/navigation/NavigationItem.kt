import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(
    val route: String,
    val icon: ImageVector,
    val label: String
) {
    object Home : NavigationItem("home", Icons.Default.Home, "Home")
    object Categories : NavigationItem("categories", Icons.Default.Menu, "Menu")
    object Cart : NavigationItem("cart", Icons.Default.ShoppingCart, "Cart")
    object Orders : NavigationItem("orders", Icons.Default.List, "Orders")
} 