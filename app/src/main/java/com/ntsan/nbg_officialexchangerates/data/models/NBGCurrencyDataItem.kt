package com.ntsan.nbg_officialexchangerates.data.models


import com.squareup.moshi.Json
import androidx.annotation.Keep

@Keep
data class NBGCurrencyDataItem(
    @Json(name = "currencies")
    val currencies: List<Currency>,
    @Json(name = "date")
    val date: String
)