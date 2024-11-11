@Composable
fun CategoriesScreen(
    navController: NavController,
    menuViewModel: MenuViewModel = hiltViewModel(),
    cartViewModel: CartViewModel = hiltViewModel()
) {
    var selectedCategory by remember { mutableStateOf(MenuCategory.DRINKS) }
    val menuItems = menuViewModel.getItemsByCategory(selectedCategory)

    Column(modifier = Modifier.fillMaxSize()) {
        // Category tabs
        ScrollableTabRow(
            selectedTabIndex = selectedCategory.ordinal,
            modifier = Modifier.fillMaxWidth(),
            edgePadding = 16.dp
        ) {
            MenuCategory.values().forEach { category ->
                Tab(
                    selected = category == selectedCategory,
                    onClick = { selectedCategory = category },
                    text = {
                        Text(
                            text = category.name.lowercase().replaceFirstChar { it.uppercase() },
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                )
            }
        }

        // Menu items
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(menuItems) { menuItem ->
                MenuItemCard(
                    menuItem = menuItem,
                    onAddToCart = { cartViewModel.addToCart(menuItem) }
                )
            }
        }
    }
}

@Composable
private fun MenuItemCard(
    menuItem: MenuItem,
    onAddToCart: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.placeholder_food),
                contentDescription = menuItem.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(120.dp)
                    .fillMaxHeight()
            )
            
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Text(
                    text = menuItem.name,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = menuItem.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "$${String.format("%.2f", menuItem.price)}",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                    IconButton(onClick = onAddToCart) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add to cart"
                        )
                    }
                }
            }
        }
    }
} 