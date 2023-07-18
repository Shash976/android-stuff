package com.littlelemon.menu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class ProductActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = intent
        val productItem =
            ProductItem(
                title = intent.getStringExtra(KEY_TITLE)!!,
                price = intent.getDoubleExtra(KEY_PRICE,0.0),
                category = intent.getStringExtra(KEY_CATEGORY)!!,
                image = intent.getIntExtra(KEY_IMAGE,0)
            )//todo replace with the passed values from intent
        setContent { ProductDetails(productItem) }
    }


    companion object {
        const val KEY_TITLE = "title"
        const val KEY_PRICE = "price"
        const val KEY_IMAGE = "image"
        const val KEY_CATEGORY = "category"
    }
}