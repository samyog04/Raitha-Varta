package com.raithavarta.util

import com.raithavarta.data.model.Category
import com.raithavarta.data.model.SuccessStory
import com.raithavarta.data.model.Tip

object DataSeeder {

    fun getCategories() = listOf(
        Category(1, "Paddy", "Bhatta"),
        Category(2, "Ragi", "Ragi"),
        Category(3, "Maize", "Mekkejola"),
        Category(4, "Tomato", "Tomatо"),
        Category(5, "Onion", "Eerulli")
    )

    fun getTips() = listOf(
        Tip(
            id = 1, categoryId = 1,
            title = "Water Management",
            titleKannada = "Water Management",
            description = "Irrigate paddy fields every 3 days during vegetative stage.",
            descriptionKannada = "Irrigate paddy fields every 3 days during vegetative stage."
        ),
        Tip(
            id = 2, categoryId = 1,
            title = "Pest Control",
            titleKannada = "Pest Control",
            description = "Spray neem oil solution to control stem borers in paddy.",
            descriptionKannada = "Spray neem oil solution to control stem borers in paddy."
        ),
        Tip(
            id = 3, categoryId = 2,
            title = "Soil Preparation",
            titleKannada = "Soil Preparation",
            description = "Add compost to soil before sowing ragi for better yield.",
            descriptionKannada = "Add compost to soil before sowing ragi for better yield."
        ),
        Tip(
            id = 4, categoryId = 2,
            title = "Fertilizer",
            titleKannada = "Fertilizer",
            description = "Apply nitrogen fertilizer at 30 days after sowing ragi.",
            descriptionKannada = "Apply nitrogen fertilizer at 30 days after sowing ragi."
        ),
        Tip(
            id = 5, categoryId = 3,
            title = "Spacing",
            titleKannada = "Spacing",
            description = "Maintain 60x45 cm spacing between maize plants for good growth.",
            descriptionKannada = "Maintain 60x45 cm spacing between maize plants for good growth."
        ),
        Tip(
            id = 6, categoryId = 4,
            title = "Drip Irrigation",
            titleKannada = "Drip Irrigation",
            description = "Use drip irrigation for tomatoes to save water and prevent disease.",
            descriptionKannada = "Use drip irrigation for tomatoes to save water and prevent disease."
        ),
        Tip(
            id = 7, categoryId = 5,
            title = "Storage",
            titleKannada = "Storage",
            description = "Store onions in dry ventilated place to prevent rotting.",
            descriptionKannada = "Store onions in dry ventilated place to prevent rotting."
        )
    )

    fun getSuccessStories() = listOf(
        SuccessStory(
            id = 1,
            farmerName = "Ramaiah",
            location = "Mandya, Karnataka",
            story = "By following drip irrigation tips from Raitha-Varta, I saved 40% water and doubled my tomato yield in one season.",
            storyKannada = "By following drip irrigation tips, I saved 40% water and doubled my tomato yield.",
            cropName = "Tomato"
        ),
        SuccessStory(
            id = 2,
            farmerName = "Lakshmi Devi",
            location = "Hassan, Karnataka",
            story = "The pest control tips helped me reduce crop loss by 60% in my paddy fields this year.",
            storyKannada = "The pest control tips helped me reduce crop loss by 60% in my paddy fields.",
            cropName = "Paddy"
        ),
        SuccessStory(
            id = 3,
            farmerName = "Venkatesh",
            location = "Tumkur, Karnataka",
            story = "Using the fertilizer schedule from the app, my ragi yield increased by 35% this season.",
            storyKannada = "Using the fertilizer schedule, my ragi yield increased by 35% this season.",
            cropName = "Ragi"
        )
    )
}