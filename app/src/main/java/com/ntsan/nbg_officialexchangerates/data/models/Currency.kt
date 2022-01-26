package com.ntsan.nbg_officialexchangerates.data.models


import com.squareup.moshi.Json
import androidx.annotation.Keep

@Keep
data class Currency(
    @Json(name = "code")
    val code: String,
    @Json(name = "date")
    val date: String,
    @Json(name = "diff")
    val diff: Double,
    @Json(name = "diffFormated")
    val diffFormated: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "quantity")
    val quantity: Int,
    @Json(name = "rate")
    val rate: Double,
    @Json(name = "rateFormated")
    val rateFormated: String,
    @Json(name = "validFromDate")
    val validFromDate: String
)