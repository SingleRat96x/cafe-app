@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        // Welcome Banner
        item {
            WelcomeBanner()
        }

        // Categories
        item {
            Text(
                text = "Categories",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(vertical = 16.dp)
            )
        }

        // Category Grid
        item {
            CategoryGrid(navController)
        }

        // Special Offers
        item {
            SpecialOffersBanner()
        }
    }
}

@Composable
private fun WelcomeBanner() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.cafe_banner),
                contentDescription = "Welcome Banner",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.7f))
                        )
                    )
            )
            Text(
                text = "Welcome to Café!\nSip, Relax, Enjoy",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp)
            )
        }
    }
}

@Composable
private fun CategoryGrid(navController: NavController) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.height(400.dp)
    ) {
        items(MenuCategory.values()) { category ->
            CategoryCard(category, navController)
        }
    }
}

@Composable
private fun CategoryCard(
    category: MenuCategory,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .clickable {
                navController.navigate("categories/${category.name}")
            },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(
                    id = when (category) {
                        MenuCategory.DRINKS -> R.drawable.category_drinks
                        MenuCategory.SANDWICHES -> R.drawable.category_sandwiches
                        MenuCategory.CHICHA -> R.drawable.category_chicha
                        MenuCategory.DESSERTS -> R.drawable.category_desserts
                    }
                ),
                contentDescription = category.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.4f))
            )
            Text(
                text = category.name.lowercase()
                    .replaceFirstChar { it.uppercase() },
                style = MaterialTheme.typography.titleLarge,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(16.dp)
            )
        }
    }
} 