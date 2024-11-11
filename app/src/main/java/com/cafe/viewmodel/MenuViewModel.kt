@HiltViewModel
class MenuViewModel @Inject constructor() : ViewModel() {
    private val _menuItems = MutableStateFlow<List<MenuItem>>(emptyList())
    val menuItems: StateFlow<List<MenuItem>> = _menuItems.asStateFlow()

    init {
        // In a real app, this would come from a repository/database
        _menuItems.value = generateSampleMenuItems()
    }

    fun getItemsByCategory(category: MenuCategory): List<MenuItem> {
        return _menuItems.value.filter { it.category == category }
    }

    private fun generateSampleMenuItems(): List<MenuItem> {
        return listOf(
            MenuItem(
                id = "1",
                name = "Espresso",
                description = "Rich and bold espresso shot",
                price = 2.99,
                imageUrl = "drinks_espresso",
                category = MenuCategory.DRINKS
            ),
            MenuItem(
                id = "2",
                name = "Cappuccino",
                description = "Espresso with steamed milk and foam",
                price = 3.99,
                imageUrl = "drinks_cappuccino",
                category = MenuCategory.DRINKS
            ),
            MenuItem(
                id = "3",
                name = "Club Sandwich",
                description = "Triple-decker with turkey, bacon, and vegetables",
                price = 8.99,
                imageUrl = "sandwiches_club",
                category = MenuCategory.SANDWICHES
            ),
            // Add more sample items here
        )
    }
} 