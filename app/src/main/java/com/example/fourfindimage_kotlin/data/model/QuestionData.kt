package com.example.fourfindimage_kotlin.data.model

data class QuestionData(
    var answer: String, var variants: String,
    var image1: Int, var image2: Int, var image3: Int, var image4: Int,
) {
    fun getImages(): List<Int> {
        var images: ArrayList<Int> = ArrayList<Int>()
        images.add(image1)
        images.add(image2)
        images.add(image3)
        images.add(image4)
        return images
    }
}