package com.example.abschlussaufgabe.remote.model

import com.squareup.moshi.Json

data class Meal(
    @Json(name = "strMealThumb") val image: String
)
