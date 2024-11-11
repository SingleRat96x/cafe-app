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