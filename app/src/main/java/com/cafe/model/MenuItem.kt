data class MenuItem(
    val id: String,
    val name: String,
    val description: String,
    val price: Double,
    val imageUrl: String,
    val category: MenuCategory
)

enum class MenuCategory {
    DRINKS,
    SANDWICHES,
    CHICHA,
    DESSERTS
} 