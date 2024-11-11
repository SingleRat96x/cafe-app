@HiltViewModel
class CartViewModel @Inject constructor() : ViewModel() {
    private val _cartItems = MutableStateFlow<List<CartItem>>(emptyList())
    val cartItems: StateFlow<List<CartItem>> = _cartItems.asStateFlow()

    private val _totalPrice = MutableStateFlow(0.0)
    val totalPrice: StateFlow<Double> = _totalPrice.asStateFlow()

    fun addToCart(menuItem: MenuItem) {
        val currentItems = _cartItems.value.toMutableList()
        val existingItem = currentItems.find { it.menuItem.id == menuItem.id }
        
        if (existingItem != null) {
            existingItem.quantity++
        } else {
            currentItems.add(CartItem(menuItem, 1))
        }
        
        _cartItems.value = currentItems
        updateTotalPrice()
    }

    fun removeFromCart(menuItem: MenuItem) {
        val currentItems = _cartItems.value.toMutableList()
        val existingItem = currentItems.find { it.menuItem.id == menuItem.id }
        
        if (existingItem != null) {
            if (existingItem.quantity > 1) {
                existingItem.quantity--
            } else {
                currentItems.remove(existingItem)
            }
        }
        
        _cartItems.value = currentItems
        updateTotalPrice()
    }

    private fun updateTotalPrice() {
        _totalPrice.value = _cartItems.value.sumOf { it.menuItem.price * it.quantity }
    }
} 