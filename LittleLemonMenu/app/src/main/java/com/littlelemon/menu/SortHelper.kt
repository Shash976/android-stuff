package com.littlelemon.menu

class SortHelper {

    fun sortProducts(type: SortType, productsList: List<ProductItem>): List<ProductItem> {
        return when (type) {
            SortType.Alphabetically -> productsList.sortAlphabetically()
            SortType.PriceAsc ->  productsList.priceAscending()
            SortType.PriceDesc -> productsList.priceDescending()
        }
    }

    private fun List<ProductItem>.sortAlphabetically(): List<ProductItem> {
        return sortedBy { it.title }
    }

    private fun List<ProductItem>.priceAscending() : List<ProductItem> {
        return sortedBy { it.price }
    }
    private fun List<ProductItem>.priceDescending() : List<ProductItem> {
        return sortedByDescending { it.price }
    }

}